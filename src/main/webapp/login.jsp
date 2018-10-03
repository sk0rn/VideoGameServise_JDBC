<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
    switch ("" + request.getParameter("errorCode")) {
        case "wrongLogin":
%>
<p style="color: #FF2222"> Error: wrongLogin.</p>
<% break;
    case "accessDenied":%>
<p style="color: #FF2222"> Error: accessDenied.</p>
<% break;
}
%>
<form action="/login" method="post" title="Создать пользователя">
    <input type="login" name="login" title="Логин"/>
    <input type="password" name="password" title="Пароль"/>
    <input type="submit" title="ok">
</form>
<%@include file="footer.jsp"%>
