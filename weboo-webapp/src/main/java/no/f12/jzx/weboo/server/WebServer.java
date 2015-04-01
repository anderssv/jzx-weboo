package no.f12.jzx.weboo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.util.Assert;

public class WebServer {
	
	private static Logger LOG = LoggerFactory.getLogger(WebServer.class);

	private Integer port;
	private Server server;

	public WebServer(int port) {
		this.port = port;
	}

	public WebServer() {
	}

	public void start(Resource webAppContextPath, String applicationContext) {
		server = startWebServer(webAppContextPath, applicationContext);
		port = getServerPort(server);
	}

	private Integer getServerPort(Server server) {
		return server.getConnectors()[0].getLocalPort();
	}

	private Server startWebServer(Resource webAppContextPath, String applicationContext) {
		Assert.isTrue(webAppContextPath.exists(), "The context path you have specified does not exist: "
				+ webAppContextPath);
		Assert.notNull(applicationContext, "You must specify the context path of the application");

		int startPort = 0;
		if (this.port != null) {
			startPort = this.port;
			LOG.info("Starting server on predetermined port: " + startPort);
		}

		if (!applicationContext.startsWith("/")) {
			applicationContext = "/" + applicationContext;
		}

		Server server = createServer(startPort);
		try {
			System.out.println("App server med: " + webAppContextPath.getURI().toString() + " på " + applicationContext);
			WebAppContext webAppContext = new WebAppContext();
			webAppContext.setWar(webAppContextPath.getURI().toString());
			webAppContext.setContextPath(applicationContext);
			setUpClassPath(webAppContext);

			server.setHandler(webAppContext);
			server.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return server;
	}

	private Server createServer(int startPort) {
		/* OpenShift requires that we bind to an internal IP, this is not the
		 * case most other places and I guess that Heroku avoids this by handing
		 * us a specific port. On OpenShift the port is always 8080.
		 */
		if (System.getenv("OPENSHIFT_DIY_IP") != null) {
			return new Server(new InetSocketAddress(System.getenv("OPENSHIFT_DIY_IP"), port));
		} else {
			return new Server(startPort);
		}
	}

	private void setUpClassPath(WebAppContext webAppContext) {
		String classpath = System.getProperty("java.class.path");
		String separator = System.getProperty("path.separator");
		if (":".equals(separator)) {
			classpath = classpath.replace(":", ";");
		}
		webAppContext.setExtraClasspath(classpath);
	}

	public Integer getPort() {
		Assert.notNull(port, "Server must be started before port can be determined");
		return this.port;
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception {
		int port = determineServerPort();
		Resource contextPath = determineContextPath();

		WebServer setupServer = new WebServer(port);
		setupServer.start(contextPath, "");
	}

	public static Resource determineContextPath() {
		ResourceLoader rs = new DefaultResourceLoader();
		
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(new FileSystemResource("./src/main/webapp")); // Local run
		resources.add(new FileSystemResource("./weboo-webapp/src/main/webapp")); // Heroku
		resources.add(new FileSystemResource("./webapp")); // Zip packaging
		resources.add(determineJarPath()); // One-jar packaging
		
		for (Resource resource : resources) {
			try {
				Boolean webInfExists =  rs.getResource(resource.getURI().toString() + "/WEB-INF/web.xml").exists();
				if (resource.exists() && webInfExists) {
				   	System.out.println(resource);
				    return resource;
				}
			} catch (IOException e) {
				throw new IllegalStateException("Could not check for web.xml in " + resource);
			}
		}
		throw new IllegalStateException("Could not determine location of webapp to load! " + resources);
	}
	
	private static Resource determineJarPath() {
		URL jarUrl = WebServer.class.getProtectionDomain().getCodeSource().getLocation();
        Resource warLocation = new UrlResource(jarUrl);
        return warLocation;
	}

	private static int determineServerPort() {
		// Ports to check, most specific first. VCAP is Cloud Foundry, PORT is
		// Heroku
		String[] portNames = new String[] { "VCAP_APP_PORT", "PORT", "OPENSHIFT_DIY_PORT" };
		for (String portName : portNames) {
			String portValue = System.getenv(portName);
			if (portValue != null && !portValue.equals("")) {
				return Integer.valueOf(portValue);
			}
		}

		// If nothing found, default to 8080
		return 8080;
	}

}
