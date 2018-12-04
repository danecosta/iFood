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
        <form action="FrontController?action=CadastrarPedidoPagamento" method="post">
            Pedido: 
            <input type="text" name="codPedido" value="${codPedido}"/><br/>
            <br>

            Tipo de Pagamento:
            <select name="textTipoPagamento">
                <c:forEach items="${tiposPagamento}" var="tipoPagamento">
                    <option value="${tipoPagamento}">${tipoPagamento}</option>
                </c:forEach> 
            </select>

            <c:if test="tipoPagamento == 'Cartão de Crédito'">
                Nº Cartão:
                <input type="text" name="txtNumCartao"/><br/>
            </c:if>

            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
