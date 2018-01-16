package com.annotationservlet.servlet;

import com.annotationservlet.App;
import com.annotationservlet.entity.Cat;
import com.annotationservlet.storage.ICatStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-cat")
public class AddCatServlet extends HttpServlet {
    private ICatStorage catStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add-cat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for(String paramName : req.getParameterMap().keySet()) {
            System.out.println(paramName + "=" + req.getParameter(paramName));
        }

        String catName = req.getParameter("catName").toString();

        boolean catSex = false;
        if (req.getParameter("catSex") != null) {
            catSex = req.getParameter("catSex").equals("on");
        }

        Cat cat = new Cat();
        cat.setName(catName);
        cat.setSex(catSex);

        catStorage.add(cat);

        resp.sendRedirect("/all");
    }
}
