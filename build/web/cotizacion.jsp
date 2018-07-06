<%-- 
    Document   : cotizacion
    Created on : 5/07/2018, 11:10:33 AM
    Author     : merlinh
--%>

<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="net.test.entities.Cotizacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.test.entities.consultarSociosWS"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizacion - Resultado</title>
    </head>
    <body>
    <%
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.CHINA);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);
        
        consultarSociosWS socios = new consultarSociosWS();
        
        int monto = 0;
        try
        {
            monto = Integer.parseInt(request.getParameter("v"));
        }
        catch(Exception e)
        {
            System.err.print("Monto: no valido " + e.getMessage());
        }
        String[] cotizacion = socios.cotizacion(monto);
        
        if(monto == 0)
        {
        %>
        <h2 align="center">Monto no válido</h2>
        <%
        }
        else
        {     
            //if(cotizacion.size() > 0) {
            //    Cotizacion temp = cotizacion.get(0);
            if(cotizacion[0] != ""){
        %>
    <table width="50%" border="1" align="center">
        <tr align="center">
            <th>Socio que realiza el préstamo</th>
            <th>Cuota mensual</th>
            <th>Pago total del crédito</th>
            <th>Tasa de interés mensual</th>
        </tr>
        <tr align="center">
            <td>
                <% out.print(cotizacion[1]); %>
            </td>
            <td>
                $<% out.print(cotizacion[2]);%>
            </td>
            <td>
                $<% out.print(cotizacion[3]);%>
            </td>
            <td>
                <% out.print(cotizacion[4]);%>%
            </td>
        </tr>
    </table>
        <%
            }
            else
            {
        %>
    <h2 align="center">No hay socio disponible</h2>
    <%
            }
        }
    %>
    <div style="width: 50%; margin: auto; border: 0px" align="right"><a href="index.jsp">&LessLess;Volver</a></div>
    </body>
</html>
