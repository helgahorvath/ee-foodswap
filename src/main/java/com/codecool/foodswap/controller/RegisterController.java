package com.codecool.foodswap.controller;

import com.codecool.foodswap.config.TemplateEngineUtil;
import com.codecool.foodswap.dao.UserDao;
import com.codecool.foodswap.dao.implementation.UserDaoImpl;
import com.codecool.foodswap.model.User;
import com.codecool.foodswap.util.RegistrationForm;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Set;


@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private WebContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        context = new WebContext(req, resp, req.getServletContext());
        engine.process("register.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context = new WebContext(req, resp, req.getServletContext());
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());


        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        RegistrationForm form = new RegistrationForm();
        form.setFirstName(req.getParameter("first_name"));
        form.setLastName(req.getParameter("last_name"));
        form.setEmail(req.getParameter("email"));
        form.setPassword(req.getParameter("password"));
        form.setPassword2(req.getParameter("password2"));

        Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(form);

        UserDao userDao = UserDaoImpl.getInstance();

        if (violations.isEmpty() && (userDao.checkIfEmailExisting(req.getParameter("email")))) {

            User user = new User(req.getParameter("first_name"),
                    req.getParameter("last_name"),
                    req.getParameter("email"),
                    req.getParameter("password"));
            userDao.add(user);

            String jsonRegistration = "{" +
                    "\"Registration:\" " + "\"successful!\"}";

            resp.getWriter().write(jsonRegistration);


        } else {

        String[] errorMessages = violations.stream().map(ConstraintViolation::getMessage).toArray(String[]::new);
        context.setVariable("errorMessages", errorMessages);
        engine.process("register.html", context, resp.getWriter());

        String jsonRegistration = "{" +
                "\"Registration:\" " + "\"unsuccessful!\"}";

            resp.getWriter().write(jsonRegistration);

        }

    }

}
