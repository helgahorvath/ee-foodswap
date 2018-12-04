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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/"})
public class LoginController extends HttpServlet {
    private WebContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserDao userDao  = UserDaoImpl.getInstance();
        GroupDao groupDao = GroupDaoImpl.getInstance();
        FoodDao foodDao = FoodDaoImpl.getInstance();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        context = new WebContext(req, resp, req.getServletContext());
        engine.process("log-reg.html", context, resp.getWriter());


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
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        UserDao userDao  = UserDaoImpl.getInstance();
        int uId = userDao.verifyUser(req.getParameter("login-email"), req.getParameter("login-pw"));
        if (req.getParameter("login-email") != null && uId > -1) {
            session.setAttribute("uId", uId);
            resp.sendRedirect("/main");
        }
    }
}

