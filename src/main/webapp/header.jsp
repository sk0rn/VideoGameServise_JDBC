<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title>${title}</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="/resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header">
        <table width="100%"><tr><td width="100%">

            <strong>Header:</strong>
            <div>
                <%--если мы залогины, то будем видеть кнопку Выйти,
                при нажатии на которую попадем в сервлет LoginServlet,
                произойдет разрыв сессии--%>
            </div>
            </td><td width="*">
            <c:if test='${role != null && role == 8}'>
                <a href="/customer/basket">Корзина</a>
                <a href="/customer/account">Личный&nbsp;кабинет</a>
            </c:if>

            <% if (request.getSession().getAttribute("login") != null) {%>
            Вы&nbsp;вошли&nbsp;как&nbsp;<%=request.getSession().getAttribute("login")%>
            <a href="/login?action=logout">Выйти</a>
            <%}%>

            <% if (request.getSession().getAttribute("login") == null) {%>
            <a href="/login">Войти&nbsp;в&nbsp;систему</a>
            <a href="/register">Зарегистрироваться</a>
            <%}%>
        </td></tr></table>

    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
