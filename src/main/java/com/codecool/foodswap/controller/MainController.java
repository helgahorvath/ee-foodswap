package com.codecool.foodswap.controller;

import com.codecool.foodswap.config.TemplateEngineUtil;
import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/"})
public class MainController extends HttpServlet {
    private WebContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        context = new WebContext(req, resp, req.getServletContext());
        testerInit();
        engine.process("log-reg.html", context, resp.getWriter());
    }

    void testerInit() {
        UserDao ud = UserDaoImpl.getInstance();
        ud.add(new User("Geza", "Takacs", "haloka@gmail.com", "dfidnvnfv"));
        ud.add(new User("Geza", "Takacs", "haloka1@gmail.com", "dfidnvnfv"));
        ud.add(new User("Geza", "Takacs", "haloka2@gmail.com", "dfidnvnfv"));


    }

}
