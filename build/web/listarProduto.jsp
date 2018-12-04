<%-- 
    Document   : listarProduto
    Created on : 24/10/2018, 19:40:26
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
        <h1>Listar Produtos</h1>

        <form action="FrontController?action=CriarProduto" method="post">
            <button type="submit">Cadastrar</button>
        </form>

        <table>
            <thead>
            <th>Código</th>
            <th>Descrição</th>
            <th>Preço</th>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.getCodProduto()}</td>
                    <td>${produto.getDescricao()}</td>
                    <td>${produto.getPreco()}</td>
                </tr>
            </c:forEach>
        </tbody>
</html>
