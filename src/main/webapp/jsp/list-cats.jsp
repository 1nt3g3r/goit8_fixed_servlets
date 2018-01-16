<%@ page import="com.annotationservlet.entity.Cat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Все коты</h2>

<%
    List<Cat> cats = (List<Cat>) request.getAttribute("cats");
    for(Cat cat: cats) {
        String link = cat.getName();
        String sex = cat.getSex() ? "мужчина" : "женщина";
        UUID id = cat.getId();
        String strId = id.toString();

        out.println("<span>" + link + ", " + sex  + "</span>");
        out.println("<a href=\"/delete-cat?catId=" + strId + "\"> Удалить </a>");
        out.println("<a style=\"background: red;\" href=\"/edit-cat?catId=" + strId + "\"> Редактировать </a>");

        out.println("</br>");
    }
%>

<a href="/add-cat">Добавить кота</a>