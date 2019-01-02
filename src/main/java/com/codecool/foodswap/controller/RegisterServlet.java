package com.codecool.foodswap.controller;

import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.User;
import org.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private String name;

    public RegisterServlet(String name){
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("in get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in reg");
        UserDao userDao = UserDaoImpl.getInstance(); // NOT DI!!!!
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        JSONObject newUser = new JSONObject(jb.toString());
        userDao.add(new User(newUser.getString("firstName"), newUser.getString("lastName"), newUser.getString("email"), newUser.getString("password")));
        String jsonRegistration = "{\"registration\": true}";
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonRegistration);
        resp.getWriter().flush();
    }

}
