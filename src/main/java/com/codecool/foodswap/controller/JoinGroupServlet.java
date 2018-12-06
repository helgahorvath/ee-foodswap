package com.codecool.foodswap.controller;

import com.codecool.foodswap.dao.GroupDao;
import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.GroupDaoImpl;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.Group;
import com.codecool.foodswap.model.User;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoinGroupServlet extends HttpServlet {
    private List<String> resultGroups = new ArrayList<>();
    private String name;
    private GroupDao groupDao = GroupDaoImpl.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();
    private HttpSession session;

    public JoinGroupServlet(String name) {
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameter("search-group") != null) {
            StringBuffer jb = new StringBuffer();
            String line;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) { /*report an error*/ }
            String searchedGroup = new JSONObject(jb.toString()).getString("searched_group_name");
            for (Group group: groupDao.findByName(searchedGroup)) {
                String jsonGroup = "{" +
                        "\"group_name\": \"" + group.getName() + "\"," +
                        "\"group_id\": \"" + group.getId() + "\"}";
                resultGroups.add(jsonGroup);
            }
        }
        resp.getWriter().write(resultGroups.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        session = req.getSession();
        if(req.getParameter("join-group") != null){
            int uId = (int) session.getAttribute("uId");
            StringBuffer jb = new StringBuffer();
            String line;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) { /*report an error*/ }
            JSONObject groupJSON = new JSONObject(jb.toString());
            int group_id = groupJSON.getInt("group_id");
            groupDao.addUserToGroup(userDao.getUserById(uId),groupDao.findById(group_id));
        }
    }
}
