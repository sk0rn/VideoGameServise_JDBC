<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Platform" %><%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<table>
    <tr>
        <th>Platforms</th>
    </tr>

    <%
        List<Platform> platforms = (List<Platform>) request.getAttribute("platforms");
        for (int i = 0; i < platforms.size(); i++) {
    %>
    <tr>
        <td><a href="/games?id=<%=platforms.get(i).getId()%>&type=platforms"><%=platforms.get(i).getName()%></a></td>
    </tr>
    <%
        }
    %>

</table>
<%@include file="../footer.jsp"%>
