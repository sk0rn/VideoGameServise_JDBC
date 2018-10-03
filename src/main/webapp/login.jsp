<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
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
<form action="/login" method="post" title="Авторизация">
    <table>
        <tr>
            <td>login</td>
            <td>password</td>
            <td></td>
        </tr>
        <tr>
            <td><input type="login" name="login" title="Логин"/></td>
            <td><input type="password" name="password" title="Пароль"/></td>
            <td><input type="submit" title="ok"></td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp" %>
