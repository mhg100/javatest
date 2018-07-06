<%-- 
    Document   : index
    Created on : 5/07/2018, 09:05:43 AM
    Author     : merlinh
--%>

<%@page import="net.test.entities.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.test.entities.consultarSociosWS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            consultarSociosWS socios = new consultarSociosWS();
            ArrayList<Persona> nombre = socios.socio();
        %>
        <table width="50%" border="1" align="center">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Tasa</th>
                <th>Valor máximo</th>
            </tr>
            <% for(int i = 0; i < nombre.size(); i++){
                Persona temp = nombre.get(i);
            %>
            <tr>
                <td>
                    <% out.print(temp.getId()); %>
                </td>
                <td>
                    <% out.print(temp.getNombre()); %>
                </td>
                <td>
                    <% out.print(temp.getTasa()*100 + "%"); %>
                </td>
                <td>
                    <% out.print(temp.getValor_max()); %>
                </td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
