<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Publisher" %><%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<table>
    <tr>
        <th>Publisher</th>
    </tr>

    <%
        List<Publisher> pubs = (List<Publisher>) request.getAttribute("publishers");
        for (int i = 0; i < pubs.size(); i++) {
    %>
    <tr>
        <td><a href="/games?id=<%=pubs.get(i).getId()%>&type=publishers"><%=pubs.get(i).getName()%></a></td>
    </tr>
    <%
        }
    %>

</table>
<%@include file="../footer.jsp"%>
