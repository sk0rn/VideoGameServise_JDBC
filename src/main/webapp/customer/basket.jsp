<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: sk0rn
  Date: 01.10.2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%

    // вместо проверки if request.getAttribute("checkout") != null &&
    // request.getAttribute("checkout") == true
    if (Boolean.TRUE.equals( request.getAttribute("checkout"))) {
%><%@include file="./basket_checkout_success.jsp"%><%
    // если пришел ответ checkout, но false
}else if(request.getAttribute("checkout") != null){
%><%@include file="./basket_checkout_warning.jsp"%><%
}else{ // обычный вход в корзину по ссылке
%><%@include file="./basket_regular.jsp"%><%

}

%>
<%@include file="../footer.jsp"%>