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

@WebServlet("/edit-cat")
public class EditCatServlet extends HttpServlet {
    private ICatStorage catStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long catId = Long.parseLong(req.getParameter("catId"));
//
//        Cat cat = catStorage.get(catId);
//
//        req.setAttribute("catName", cat.getName());
//        req.setAttribute("catSex", cat.getSex() ? "on" : "off");
//        req.setAttribute("catId", cat.getId());
//
//        req.getRequestDispatcher("/jsp/edit-cat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WE ARE REALLY CLOSE!");
    }
}
