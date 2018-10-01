<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Genre" %><%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Genres</title>
</head>
<body>
<table>
    <tr>
        <th>Genre</th>
    </tr>

    <%
        List<Genre> genres = (List<Genre>) request.getAttribute("genres");
        for (int i = 0; i < genres.size(); i++) {
    %>
    <tr>
        <td><a href="/games?id=<%=genres.get(i).getId()%>"><%=genres.get(i).getName()%></a></td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
