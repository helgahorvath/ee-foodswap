package com.codecool.foodswap.controller;


import com.codecool.foodswap.config.TemplateEngineUtil;
import com.codecool.foodswap.dao.implementation.FoodDaoImpl;
import com.codecool.foodswap.dao.implementation.GroupDaoImpl;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/main"})
public class MainController extends HttpServlet {
    private WebContext context;
    /*private FoodDaoImpl foodDao = FoodDaoImpl.getInstance();
    private GroupDaoImpl groupDao = GroupDaoImpl.getInstance();*/
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        session = req.getSession();
        session.getAttribute("uId");
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        context = new WebContext(req, resp, req.getServletContext());
       /* context.setVariable("foods", foodDao.getAllFoodByGroup(groupDao.findByName("My office")));*/
        engine.process("swap-list.html", context, resp.getWriter());
    }
}
