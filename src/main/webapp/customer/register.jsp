<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../header.jsp"%>

<% if("badPassword".equals(request.getParameter("errorCode"))) {%>
<p style="color: #FF2222">Пароль должен состоять не менен чем из 8 символов,
    должен содержать две прописные, две заглавные буквы и две цифры</p>
<%}%>

<form action="/register" method="post">
    <table>
        <tr>
            <td>Enter name</td>
            <td>Enter password</td>
        </tr>
        <tr>
            <td><input type="text" name="login"/></td>
            <td><input type="text" name="pass"/></td>
            <td><input type="submit" title="ok"></td>
        </tr>
    </table>
</form>
<%@include file="../footer.jsp"%>
