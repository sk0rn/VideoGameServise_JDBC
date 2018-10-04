<%@ page import="java.util.List" %>
<%@ page import="pojo.game.*" %>
<%@include file="../header.jsp"%>
<form action="/add_content/add_game" method="post">
    <table>
        <tr><td>Choose title</td>
        <td><select name="title"><%
        List<Title> titles = (List<Title>) request.getAttribute("titles");
        int id;
        String name;
        for (int i = 0; i < titles.size(); i++) {
            id = titles.get(i).getId();
            name = titles.get(i).getName();
    %><option value="<%= id %>" ><%= name %></option><%
            }
        %></select>
            </td>
        </tr>
        <tr><td>Quantity</td><td><input type="text" name="quantity"></td></tr>
        <tr><td>Choose genre</td>
            <td><select name="genre">

                    <%
        List<Genre> genres = (List<Genre>) request.getAttribute("genres");

        for (int i = 0; i < genres.size(); i++) {
            id = genres.get(i).getId();
            name = genres.get(i).getName();
    %><option value="<%= id %>" ><%= name %></option><%
            }
        %></select>
            </td>
        </tr>
        <tr><td>Choose developer</td>
            <td><select name="developer">

                <%
                    List<Developer> developers = (List<Developer>) request.getAttribute("developers");

                    for (int i = 0; i < developers.size(); i++) {
                        id = developers.get(i).getId();
                        name = developers.get(i).getName();
                %><option value="<%= id %>" ><%= name %></option><%
                }
            %></select>
            </td>
        </tr>
        <tr><td>Choose publisher</td>
            <td><select name="publisher">

                <%
                    List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");

                    for (int i = 0; i < publishers.size(); i++) {
                        id = publishers.get(i).getId();
                        name = publishers.get(i).getName();
                %><option value="<%= id %>" ><%= name %></option><%
                }
            %></select>
            </td>
        </tr>
        <tr><td>Release year</td><td><input type="text" name="year"></td></tr>
        <tr><td>Choose platform</td>
            <td><select name="platform">

                <%
                    List<Platform> platforms = (List<Platform>) request.getAttribute("platforms");

                    for (int i = 0; i < platforms.size(); i++) {
                        id = platforms.get(i).getId();
                        name = platforms.get(i).getName();
                %><option value="<%= id %>" ><%= name %></option><%
                }
            %></select>
            </td>
        </tr>
        <tr><td>Price</td><td><input type="text" name="price"></td></tr>
        <tr><td align="center" colspan="2"><input type="submit" title="ok"></td></tr>
    </table>
</form>
<%@include file="../footer.jsp"%>
