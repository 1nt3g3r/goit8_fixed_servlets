<%@ page import="com.annotationservlet.entity.Cat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Добавление кота</h2>

<form action="/add-cat" method="POST">
    <h3>Имя кота</h3>
    <input type="text" name="catName"/>

    <br/>

    <input type="checkbox" name="catSex"/> <span>Мужчина</span>

    <br/>

    <input type="submit" value="Добавить кота"/>
</form>

<a href="/all">Список котов</a>