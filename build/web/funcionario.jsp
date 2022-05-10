<%-- 
    Document   : cliente
    Created on : 9 de mai. de 2022, 21:54:28
    Author     : Fatec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pessoa"%>
<%@page import="java.util.ArrayList"%>

<%
    Exception requestEx = null;
    ArrayList<Pessoa> list = new ArrayList<>();
    int count = 0;
    try {
        count = Pessoa.getCountEmployees();
        list = Pessoa.getListEmployees();
    } catch (Exception ex) {
        requestEx = ex;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Hugo Sergio Alves de Souza</h2>
        <h2>RA: 1290482023025</h2>
        <h1>Funcionario</h1>
        <% if (requestEx != null) {%>
        <h2 style="color:red"><%= requestEx.getMessage()%></h2>
        <%}%>

        <table border="1">
            <tr><th>Id</th><th>Nome</th></tr>
                    <% for (Pessoa a : Pessoa.getListEmployees()) {%>
            <tr>
                <td><%= a.getFirstName()%></td>
                <td><%= a.getLastName()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
