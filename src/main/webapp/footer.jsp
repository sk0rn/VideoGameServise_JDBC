<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</main><!-- .content -->
</div><!-- .container-->

<aside class="left-sidebar">
    <strong>Menu</strong>
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/games_list">All Games</a></li>
        <li><a href="/genres">Genres</a></li>
        <li><a href="/titles">Titles</a></li>
        <li><a href="/developers">Developers</a></li>
        <li><a href="/publishers">Publishers</a></li>
        <li><a href="/platforms">Platforms</a></li>
        <c:if test='${role != null && role == 1}'>
        <br><br>
        <p><li><a href="/add_content/add_game">New Game</a></li><p>
        <p><li><a href="/add_content/add_genre.jsp">New Genre</a></li><p>
        <p><li><a href="/add_content/add_title.jsp">New Title</a></li><p>
        <p><li><a href="/add_content/add_developer.jsp">New Developer</a></li><p>
        <p><li><a href="/add_content/add_publisher.jsp">New Publisher</a></li><p>
        <p><li><a href="/add_content/add_platform.jsp">New Platform</a></li><p>
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
