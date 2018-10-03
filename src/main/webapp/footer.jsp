<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</main><!-- .content -->
</div><!-- .container-->

<aside class="left-sidebar">
    <strong>Menu</strong>
    <ul>
        <li><a href="/games_list">All Games</a></li>
        <li><a href="/genres">Genres</a></li>
        <li><a href="/developers">Developers</a></li>
        <c:if test='${role != null && role == 1}'>
        <br><br>
        <p><li><a href="/add_developer.jsp">New Developer</a></li>    <p>
        </c:if>
    </ul>
</aside><!-- .left-sidebar -->

</div><!-- .middle-->
</div><!-- .wrapper -->

<footer class="footer">
    <strong>Footer:</strong>
</footer><!-- .footer -->

</body>
</html>
