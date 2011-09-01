package no.f12.jzx.weboo;

import java.io.File;

import no.f12.jzx.weboo.jetty.WebServer;

public class Server {

	    public static void main(String[] args) throws Exception{
	    	System.out.println("Starting server...");
			WebServer setupServer = new WebServer(Integer.valueOf(System.getenv("PORT")));
			setupServer.start(new File("./weboo-webapp/src/main/webapp"), "myapp");
	    }
}
