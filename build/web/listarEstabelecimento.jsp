<%-- 
   Document   : listarEstabelecimento
   Created on : 29/10/2018, 19:22:56
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
        <h1>Listar Estabelecimentos</h1>

        <form action="FrontController?action=CriarEstabelecimento" method="post">
            <button type="submit">Cadastrar</button>
        </form>

        <table>
            <thead>
            <th>Código</th>
            <th>Nome</th>
        </thead>
        <tbody>
            <c:forEach var="estabelecimento" items="${estabelecimentos}">
                <tr>
                    <td>${estabelecimento.getCodEstabelecimento()}</td>
                    <td>${estabelecimento.getNome()}</td>
                </tr>
            </c:forEach>
        </tbody>
</html>
