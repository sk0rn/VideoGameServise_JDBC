<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Game" %><%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<table border="1">

    <tr>
        <th>Title</th>
        <th>Quantity</th>
        <th>Genre</th>
        <th>Developer</th>
        <th>Publisher</th>
        <th>Release year</th>
        <th>Platform</th>
        <th>Price</th>
    </tr>

    <%
        List<Game> games = (List<Game>) request.getAttribute("games");
    for (int i = 0; i < games.size(); i++) {
    %>
    <tr>
        <td><%=games.get(i).getTitle().getName()%></td>
        <td><%=games.get(i).getQuantity()%></td>
        <td><%=games.get(i).getGenre().getName()%></td>
        <td><%=games.get(i).getDev().getName()%></td>
        <td><%=games.get(i).getPub().getName()%></td>
        <td><%=games.get(i).getReleaseYear()%></td>
        <td><%=games.get(i).getPlatform().getName()%></td>
        <td><%=games.get(i).getPrice()%></td>
    </tr>

    <%
    }
    %>

</table>
<%@include file="../footer.jsp"%>
