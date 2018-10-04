<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Developer" %>
<%@ page import="pojo.game.Title" %><%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<table>
    <tr>
        <th>Developer</th>
    </tr>

    <%
        List<Title> titles = (List<Title>) request.getAttribute("titles");
        for (int i = 0; i < titles.size(); i++) {
    %>
    <tr>
        <td><a href="/games?id=<%=titles.get(i).getId()%>&type=titles"><%=titles.get(i).getName()%></a></td>
    </tr>
    <%
        }
    %>

</table>
<%@include file="../footer.jsp"%>
