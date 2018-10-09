<%@ page import="pojo.orders.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.orders.OrderDetails" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<table border="1">

    <tr>
        <th>Игра</th>
        <th>Количество</th>
    </tr>
    <%
        List<OrderDetails> details = (List<OrderDetails>) request.getAttribute("order_details");
        OrderDetails orderDetails;
        for (int i = 0; i < details.size(); i++) {
            orderDetails = details.get(i);
    %>
    <tr>
        <td><%=orderDetails.getGameName()%>
        </td>
        <td><%=orderDetails.getAmount()%>
        </td>
    </tr>
    <%
        }
    %>

</table>
<%@include file="../footer.jsp"%>