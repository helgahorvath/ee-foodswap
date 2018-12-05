package com.codecool.foodswap.controller;

import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.Group;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;


public class LoginServlet extends HttpServlet {
     private String name;
     private String jsonResp;
     private URL url;
     private HttpURLConnection connection;

    public LoginServlet(String name) {
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        jsonResp = "{\"render\":true}";
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Max-Age", "1728000");
        resp.getWriter().write(jsonResp);
        resp.getWriter().flush();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        JSONObject loginDetails = new JSONObject(jb.toString());
        UserDao userDao  = UserDaoImpl.getInstance();
        int uId = userDao.verifyUser(loginDetails.getString("user_name"), loginDetails.getString("password"));
        System.out.println(uId);
        if (req.getParameter("login-email") != null && uId > 0) {
            session.setAttribute("uId", uId);
            resp.sendRedirect("/index");
        } else {
            jsonResp = "{\"login:\" \" Failed\"}";
            resp.getWriter().write(jsonResp);
        }
    }
}

