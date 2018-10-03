<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <strong>Header:</strong>
        <div>
            <%--если мы залогины, то будем видеть кнопку Выыйти,
            при нажатии на которую попадем в сервлет LoginServlet,
            произойдет разрыв сессии--%>
            <% if (request.getSession().getAttribute("login") != null) {%>
            Вы вошли как <%=request.getSession().getAttribute("login")%>
            <a href="/login?action=logout">Выйти</a>
            <%}%>
        </div>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
