<%-- 
    Document   : cadastrarPedido
    Created on : 23/10/2018, 20:11:24
    Author     : daniela.costa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iFood</title>
    </head>
    <body>
        <h1>Cadastro de Pedido</h1>
        <form action="FrontController?action=CadastrarPedido" method="post">
            Código:
            <input type="text" name="textCodigo"/><br/>   

            Cliente:
            <select name="textCodigoCliente">
                <c:forEach items="${clientes}" var="cliente">
                    <option value="${cliente.getCodCliente()}">${cliente.getNome()}</option>
                </c:forEach> 
            </select>
            
            Estabelecimento:
            <select name="textCodigoEstabelecimento">
                <c:forEach items="${estabelecimentos}" var="estabelecimento">
                    <option value="${estabelecimento.getCodEstabelecimento()}">${estabelecimento.getNome()}</option>
                </c:forEach> 
            </select>
            <input type="submit" value="Próxima"/>
        </form>
    </body>
</html>
