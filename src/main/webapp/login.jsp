<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
    if ("wrongLogin".equals(request.getParameter("errorCode"))) {
%>
<p style="color: #FF2222"> Error: wrongLogin.</p>
<%
    }
%>
<form action="/login" method="post" title="Создать пользователя">
    <input type="login" name="login" title="Логин"/>
    <input type="password" name="password" title="Пароль"/>
    <input type="submit" title="ok">
</form>
<%@include file="footer.jsp"%>
