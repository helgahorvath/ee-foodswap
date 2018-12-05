package com.codecool.foodswap.controller;

import com.codecool.foodswap.config.TemplateEngineUtil;
import com.codecool.foodswap.dao.implementation.FoodDaoImpl;
import com.codecool.foodswap.dao.implementation.GroupDaoImpl;
import com.codecool.foodswap.model.Group;
import org.json.JSONObject;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {
    private GroupDaoImpl groupDao = GroupDaoImpl.getInstance();
    private HttpSession session;
    private String name;

    public IndexServlet(String name) {
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<String> resultGroups = new ArrayList<>();
        session = req.getSession();
        int uId = (Integer) session.getAttribute("uId");
        List<Group> groupdOfUser = groupDao.getAllGroupByUserId(uId);
        for (Group group : groupdOfUser) {
            String jsonGroup = "{" +
                    "\"group_name:\" \"" + group.getName() + "\"," +
                    "\"group_id:\" \"" + group.getId() + "\"}";
            resultGroups.add(jsonGroup);
        }
        resp.getWriter().write(resultGroups.toString());
    }
}
