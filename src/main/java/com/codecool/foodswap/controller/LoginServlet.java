package com.codecool.foodswap.controller;

import com.codecool.foodswap.config.TemplateEngineUtil;
import com.codecool.foodswap.dao.FoodDao;
import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.FoodDaoImpl;
import com.codecool.foodswap.dao.implementation.GroupDaoImpl;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.DietType;
import com.codecool.foodswap.model.Food;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import org.json.JSONObject;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginServlet extends HttpServlet {
     private GroupDao groupDao = GroupDaoImpl.getInstance();
     private FoodDao foodDao = FoodDaoImpl.getInstance();
     private WebContext context;
     private String name;
     private String jsonResp;

    public LoginServlet(String name) {
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserDao userDao  = UserDaoImpl.getInstance();
        context = new WebContext(req, resp, req.getServletContext());

        List<DietType> dt = new ArrayList<>();
        dt.add(DietType.GLUTENFREE);
        dt.add(DietType.LACTOSEFREE);

        User user = new User("Geri", "Kudo", "gery89@gmail.com", "1234");
        userDao.add(user);
        Group group = new Group("My office", user);

        groupDao.addUserToGroup(user, group);

        userDao.addDietTypes(user, dt);
        groupDao.add(group);
        Food food = new Food("B+leves", "nincsimidzs", dt, "romolott", user);
        foodDao.add(food);

        jsonResp = "{\"render:\" \" true\"}";
        resp.getWriter().write(jsonResp);

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
            jsonResp = "{\"login:\" \" Successful\"}";
            resp.getWriter().write(jsonResp);
        } else {
            jsonResp = "{\"login:\" \" Failed\"}";
            resp.getWriter().write(jsonResp);
        }
    }
}

