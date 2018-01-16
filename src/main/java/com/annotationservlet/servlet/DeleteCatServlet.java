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

@WebServlet("/delete-cat")
public class DeleteCatServlet extends HttpServlet {
    private ICatStorage catStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long catId = Long.parseLong(req.getParameter("catId"));

        Cat cat = catStorage.get(catId);
        catStorage.delete(cat);

        resp.sendRedirect("/all");
    }
}
