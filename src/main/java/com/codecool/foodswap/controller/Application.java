package com.codecool.foodswap.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.addServlet("login", new LoginServlet("login")).addMapping("/");
        context.addServlet("index", new IndexServlet("index")).addMapping("/index");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}