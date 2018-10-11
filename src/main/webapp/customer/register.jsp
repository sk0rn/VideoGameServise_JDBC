<%@include file="../header.jsp"%>
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
