<%@ page import="pojo.orders.Order" %>
<%@ page import="java.util.List" %>
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
        <th>Номер заказа</th>
        <th>Дата заказа</th>
        <th>Дата возврата</th>
        <th>Статус</th>
    </tr>

    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        Order order;
        for (int i = 0; i < orders.size(); i++) {
            order = orders.get(i);
    %>
    <tr>
        <td><a href="/customer/account/orders/order?id=<%=orders.get(i).getId()%>&type=orders"><%=orders.get(i).getId()%></a></td>
        </td>
        <td><%=order.getDateOrder()%>
        </td>
        <td><%=order.getDateReturn()%>
        </td>
        <td><% if (order.getStatus() == 1) {%>
            <p>В обработке</p>
            <%}%>
        </td>
    </tr>
    <%
        }
    %>

</table>
<%@include file="../footer.jsp"%>