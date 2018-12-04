<%-- 
    Document   : listarPedido
    Created on : 24/10/2018, 19:40:20
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
        <h1>Listar Pedidos</h1>

        <form action="FrontController?action=CriarPedido" method="post">
            <button type="submit">Cadastrar</button>
        </form>

        <table>
            <thead>
            <th>Código</th>
            <th>Estabelecimento</th>
            <th>Cliente</th>
            <th>Tipo de Pagamento</th> 
            <th>Status</th>
        </thead>
        <tbody>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>${pedido.getCodPedido()}</td>
                    <td>${pedido.getCodEstabelecimento()}</td>
                    <td>${pedido.getCodCliente()}</td>
                    <td>${pedido.getCodPagamento()}</td>
                    <td></td>
                </tr>
            </c:forEach>        
        </tbody>
    </table>

    <br>

    <form action="FrontController?action=CancelarPedido" method="post">
        <h3>Cancelar</h3>
        Código:
        <select name="txtCodigoCancelar">
            <c:forEach items="${pedidos}" var="pedido">
                <option value="${pedido.getCodPedido()}">${pedido.getCodPedido()}</option>
            </c:forEach> 
        </select>
        <input type="submit" value="Salvar"/>
    </form>

    <form action="FrontController?action=PrepararPedido" method="post">
        <h3>Preparar</h3>
        Código:
        <select name="txtCodigoPreparar">
            <c:forEach items="${pedidos}" var="pedido">
                <option value="${pedido.getCodPedido()}">${pedido.getCodPedido()}</option>
            </c:forEach> 
        </select>
        <input type="submit" value="Salvar"/>
    </form>

    <form action="FrontController?action=EnviarPedido" method="post">
        <h3>Enviar</h3>
        Código:
        <select name="txtCodigoEnviar">
            <c:forEach items="${pedidos}" var="pedido">
                <option value="${pedido.getCodPedido()}">${pedido.getCodPedido()}</option>
            </c:forEach> 
        </select>
        <input type="submit" value="Salvar"/>
    </form>

    <form action="FrontController?action=EntregarPedido" method="post">
        <h3>Entregar</h3>
        Código:
        <select name="txtCodigoEntregar">
            <c:forEach items="${pedidos}" var="pedido">
                <option value="${pedido.getCodPedido()}">${pedido.getCodPedido()}</option>
            </c:forEach> 
        </select>
        <input type="submit" value="Salvar"/>
    </form>

</body>
</html>
