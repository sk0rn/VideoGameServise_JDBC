<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Developer" %><%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%
    if (((Integer)1).equals(request.getSession().getAttribute("role"))) {
%>
<form action="/add_developer" method="post">
    <input type="country" name="name"/>
    <input type="submit" title="ok">
</form>
<%
    }
%>
<table>
    <tr>
        <th>Developer</th>
    </tr>

    <%
        List<Developer> devs = (List<Developer>) request.getAttribute("developers");
        for (int i = 0; i < devs.size(); i++) {
    %>
    <tr>
        <td><a href="/games?id=<%=devs.get(i).getId()%>&type=devs"><%=devs.get(i).getName()%></a></td>
    </tr>
    <%
        }
    %>

</table>
<%@include file="footer.jsp"%>
