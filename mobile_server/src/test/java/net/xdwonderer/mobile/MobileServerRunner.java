package net.xdwonderer.mobile;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MobileServerRunner {
	private Server server;

	public static void main(String[] args) throws Exception {
		new MobileServerRunner().start(8083);
	}

	public void start(int port) throws Exception {
        System.setProperty("org.mortbay.util.URI.charset", "ISO-8859-1");
		server = new Server(port);
		server.setHandler(new WebAppContext("src/main/webapp", "/"));
		server.start();
        System.out.println("Mobile Server Started");
    }
	
	public void stop() throws Exception {
		server.stop();
	}
	
}
