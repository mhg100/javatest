<%-- 
    Document   : cotizacion
    Created on : 5/07/2018, 11:10:33 AM
    Author     : merlinh
    Description: Resultado de la ejecución del formulario en index.jsp
--%>

<%-- imports necesarios --%>
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
        //Declaración de formatter para enriquecer los valores monetarios
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        //Declaración de objeto con los métodos necesarios
        consultarSociosWS socios = new consultarSociosWS();
        
        //Prevención de parámetro vacío
        int monto = 0;
        //Tratar de obtener el valor a ser consultado
        try
        {
            //Si el parámetro es correcto, iguala a la variable....
            monto = Integer.parseInt(request.getParameter("v"));
        }
        catch(Exception e)
        {
            //Si no, lanza error por consola y no modifica el valor de la variable
            System.err.print("Monto: no valido " + e.getMessage());
        }
        //Se realiza la consulta al objeto
        String[] cotizacion = socios.cotizacion(monto);
        
        if(monto == 0) //Si el monto es igual a cero (caso que se haya ingresado 0 o valor invalido)
        {
        %>
        <h2 align="center">Monto no válido</h2> <%-- se imprime en la vista la advertencia --%>
        <%
        }
        else
        {
            //Si la cotizacion tiene valores, se mueistra la tabla...
            if(cotizacion[0] != null){
        %>
    <%-- tabla con la información --%>
    <table width="50%" border="1" align="center">
        <tr align="center">
            <th>Socio que realiza el préstamo</th>
            <th>Cuota mensual</th>
            <th>Pago total del crédito</th>
            <th>Tasa de interés mensual</th>
        </tr>
        <tr align="center">
            <td>
                <% out.print(cotizacion[1]); //Nombre del socio %>
            </td>
            <td>
                <% out.print(formatter.format(Double.parseDouble(cotizacion[2]))); //cuota mensual %>
            </td>
            <td>
                <% out.print(formatter.format(Double.parseDouble(cotizacion[3]))); //pago total%>
            </td>
            <td>
                <% out.print(cotizacion[4]); //tasa de interes mensual %>%
            </td>
        </tr>
    </table>
        <%
            }
            else
            {
            //Si la tabla no tiene valores, ne informa
        %>
    <h2 align="center">No hay socio disponible</h2>
    <%
            }
        }
    %>
    <%-- Link para ir al formulario --%>
    <div style="width: 50%; margin: auto; border: 0px" align="right"><a href="index.jsp">&LessLess;Volver</a></div>
    </body>
</html>
