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
        context.addServlet("login", new  LoginServlet("login")).addMapping("/login");
        context.addServlet("index", new IndexServlet("index")).addMapping("/groups");
        context.addServlet("creategroup", new CreateGroupServlet("cr_group")).addMapping("/create_group");
        context.addServlet("joingroup", new JoinGroupServlet("jn_group")).addMapping("/join_group");
        context.addServlet("registration", new RegisterServlet("registration")).addMapping("/registration");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}