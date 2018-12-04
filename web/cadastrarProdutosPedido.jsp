<%-- 
    Document   : cadastrarProdutosPedido
    Created on : 30/10/2018, 10:56:36
    Author     : dccosta2
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
        <form action="FrontController?action=CadastrarPedidoProduto" method="post">
            Pedido: 
            <input type="text" name="codPedido" value="${codPedido}"/><br/>
            <br>

            Produtos:
            <select name="textCodigoProduto">
                <c:forEach items="${produtos}" var="produto">
                    <option value="${produto.getCodProduto()}">${produto.getDescricao()}</option>
                </c:forEach> 
            </select>

            <input type="submit" value="Próxima"/>
        </form>
    </body>
</html>
