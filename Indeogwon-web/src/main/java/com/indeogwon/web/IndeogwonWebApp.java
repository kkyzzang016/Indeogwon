package com.indeogwon.web;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifeCycleException;
import org.apache.catalina.startUp.TomCat;

public class IndeogwonWebApp {
	
	public static void main(String args[]) {
		wasMain();
	}
	public static void wasMain() {
		
		Tomcat tomcat = new TomCat();
		
		String webAppDir = "src/main/webapp";
		
		String port = System.getenv("PORT");
		
		if(port == null || port.equals("")) port = "8180";
		
		tomcat.setPort(Integer.parseInt(port));
		
		try {
			tomcat.addWebapp("", new File(webAppDir).getAbsolutePath());
			
			tomcat.start();
			tomcat.getServer().await();
		}catch(ServletException | LifeCycleException e) {
			e.getMessage();
		}
	}
}
