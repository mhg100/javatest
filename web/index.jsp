<%-- 
    Document   : index
    Created on : 5/07/2018, 12:51:48 PM
    Author     : merlinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizacion - Inicio</title>
    </head>
    <body>
        <form name="cotizacion" action="cotizacion.jsp" method="get">
            <table width="50%" border="1" align="center">
                <tr align="center">
                    <td>Ingrese el monto</td>
                    <td><input name="v" pattern="[0-9]*" required /></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Calcular cotización" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
