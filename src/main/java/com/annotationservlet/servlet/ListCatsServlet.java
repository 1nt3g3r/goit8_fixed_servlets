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
import java.util.List;

@WebServlet("/all")
public class ListCatsServlet extends HttpServlet {
    private ICatStorage storage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cat> cats = storage.listAllCats();
        req.setAttribute("cats", cats);
        req.getRequestDispatcher("/jsp/list-cats.jsp").forward(req, resp);
    }
}
