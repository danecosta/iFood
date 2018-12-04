<%-- 
    Document   : listarCliente
    Created on : 24/10/2018, 19:40:12
    Author     : daniela.costa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iFood</title>
    </head>
    <body>
        <h1>Listar Clientes</h1>

        <form action="FrontController?action=CriarCliente" method="post">
            <button type="submit">Cadastrar</button>
        </form>

        <table>
            <thead>
            <th>Código</th>
            <th>Nome</th>
            <th>Rua</th> 
            <th>Número</th>
            <th>Bairro</th>
            <th>CEP</th>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.getCodCliente()}</td>
                    <td>${cliente.getNome()}</td>
                    <td>${contato.getRua()}</td>
                    <td>${contato.getNumero()}</td>
                    <td>${contato.getBairro()}</td>
                    <td>${contato.getCep()}</td>
                </tr>
            </c:forEach>
        </tbody>
</body>
</html>
