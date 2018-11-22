package com.codecool.foodswap.controller;

import com.codecool.foodswap.config.TemplateEngineUtil;
import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
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


@WebServlet(urlPatterns = {"/"})
public class LoginController extends HttpServlet {
    private WebContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserDao userDao  = UserDaoImpl.getInstance();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        context = new WebContext(req, resp, req.getServletContext());
        engine.process("log-reg.html", context, resp.getWriter());
        userDao.add(new User("Geri", "Kudo", "gery89@gmail.com", "1234"));
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

