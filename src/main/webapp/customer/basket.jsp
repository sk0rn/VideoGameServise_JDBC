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
<%

    if (Boolean.TRUE.equals( request.getAttribute("checkout"))) {
%><%@include file="./basket_checkout_success.jsp"%><%
}else if(request.getAttribute("checkout") != null){
%><%@include file="./basket_checkout_warning.jsp"%><%
}else{
%><%@include file="./basket_regular.jsp"%><%

}

%>
<%@include file="../footer.jsp"%>