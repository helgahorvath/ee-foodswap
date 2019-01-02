package com.codecool.foodswap.controller;

import com.codecool.foodswap.dao.implementation.GroupDaoImpl;
import com.codecool.foodswap.model.Group;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {
    private GroupDaoImpl groupDao = GroupDaoImpl.getInstance(); // not DI!!
    private String name;

    public IndexServlet(String name) {
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<String> resultGroups = new ArrayList<>();
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("uId"));
        int uId = 1; //(Integer) session.getAttribute("uId");
        List<Group> groupdOfUser = groupDao.getAllGroupByUserId(uId);
        for (Group group : groupdOfUser) {
            String jsonGroup = "{" +
                    "\"group_name\": \"" + group.getName() + "\"," +
                    "\"group_id\": \"" + group.getId() + "\"}";
            resultGroups.add(jsonGroup);
        }
        resp.getWriter().write(resultGroups.toString());
    }
}
