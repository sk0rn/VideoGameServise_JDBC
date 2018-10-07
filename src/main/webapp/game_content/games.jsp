<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.game.Game" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>
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
        Game game;
        String style;
        // выделяем свежедобавленную игру в списке
        int addedGame = request.getAttribute("new game id") == null ? -1 : (int) request.getAttribute("new game id");
        for (int i = 0; i < games.size(); i++) {
            style = addedGame == games.get(i).getId() ? "background-color: #76ffdb" : "";
            game = games.get(i);
    %>
    <tr style="<%=style%>">
        <td><%=game.getTitle().getName()%>
        </td>
        <td><%=game.getQuantity()%>
        </td>
        <td><%=game.getGenre().getName()%>
        </td>
        <td><%=game.getDev().getName()%>
        </td>
        <td><%=game.getPub().getName()%>
        </td>
        <td><%=game.getReleaseYear()%>
        </td>
        <td><%=game.getPlatform().getName()%>
        </td>
        <td><%=game.getPrice()%>
        </td>
        <td>
            <%--показывам кнопку добавить в корзину--%>
            <c:if test='${role != null && role == 8}'>
                <%
                    if (game.getQuantity() > 0) {%>
                <button class="gButton" id="g_uid<%=game.getId()%>" onclick="handleAddButton(<%=game.getId() + ", " +
         "'" + game.getTitle().getName() + "'"%>)">add
                </button>
                <%} else {%>
                <button class="gButton" id="oos">out of stock</button>
                <%}%>
            </c:if>
        </td>
    </tr>
    <%
        }
    %>

</table>
<script>
    // выволнится перед полной загрузкой страницы
    document.addEventListener("DOMContentLoaded", function () {
        // делаем так, что бы кнопки добавленных игр были не активны, даже
        // после обновления страницы
        var vButtons = document.getElementsByClassName("gButton");
        var cNames = getCookiesNames();
        for (var j = 0; j < vButtons.length; j++) {
            if (cNames.indexOf(vButtons[j].id) > -1 || vButtons[j].id === "oos") {
                vButtons[j].disabled = true;
            }
        }

    })

    // обрабатываем события после нажатия кнопки добавить игру в корзину (add)
    function handleAddButton(id, name) {
        document.getElementById("g_uid" + id).disabled = true;
        setCookie("g_uid" + id, encodeURI(name), 365);
        alert("Игра " + name + " добавлена в корзину");
    }

    // устанавиливаем куки
    function setCookie(cName, cValue, exDays) {
        var d = new Date();
        d.setTime(d.getTime() + (exDays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toUTCString();
        document.cookie = cName + "=" + cValue + ";" + expires + ";path=/";
    }

    // получаем список куки
    function getCookiesNames() {
        // в методе из имен выбираем только ид кнопок соответсвующих игр
        var cookies = document.cookie.split(';');
        var names = [];
        for (var i = 0; i < cookies.length; i++) {
            names.push(cookies[i].split('=')[0].trim()); // элементы массива свыше 0 пропустятся
        }
        return names;
    }
</script>
<%@include file="../footer.jsp" %>
