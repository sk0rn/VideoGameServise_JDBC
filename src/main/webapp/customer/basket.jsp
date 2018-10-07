<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <th>Genre</th>
        <th>Platform</th>
        <th>Price</th>
    </tr>
    <%
        Game game;
        int sum = 0;
        List<Game> games = (List<Game>) request.getAttribute("basket");
        for (int i = 0; i < games.size(); i++) {
            game = games.get(i);
            sum += game.getPrice();
    %>
    <tr>
        <td><%=games.get(i).getTitle().getName()%></td>
        <td><%=games.get(i).getGenre().getName()%></td>
        <td><%=games.get(i).getPlatform().getName()%></td>
        <td><%=games.get(i).getPrice()%></td>
        <td>
            <%--показывам кнопку добавить в корзину--%>
                <button class="gButton" id="g_uid<%=game.getId()%>" onclick="handleRemoveButton(<%=game.getId()%>)">remove</button>
        </td>
    </tr>
    <%
        }
    %>
    <tr>
        <td><%="Итого сумма заказа: " + sum + " рублей"%></td>
    </tr>
    <script>
        // опработака нажатой кнопки remove(кдалить из корзины)
        function handleRemoveButton(id) {
            //удаляем куки
            removeCookie("g_uid"+ id)
            // перезагружаем страницу
            location.reload();
        }

        function removeCookie(cName) {
            // устанавливаем дату действия куки задним числом
            document.cookie = cName + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/;';
        }
    </script>

</table>
<%@include file="../footer.jsp"%>