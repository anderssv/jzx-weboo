package no.f12.jzx.weboo.jettyapp;

import java.io.File;

import no.f12.jzx.weboo.jetty.WebServer;

/**
 * Starts a server pointing to a directory with hot-deploy
 * 
 * WARNING: If you are using mvn eclipse:eclipse it does not pick up on the fact
 * that the web project should be added to the classpath of this server project.
 * You'll have to do that manually.
 */
public class StartTestServer {

	public static void main(String[] args) {
		WebServer server = new WebServer(8080);
		server.start(new File("src/main/webapp"), "/myapp");
	}

}
