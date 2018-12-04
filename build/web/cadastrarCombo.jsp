<%-- 
    Document   : cadastrarCombo
    Created on : 30/10/2018, 12:24:49
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
        <h1>Cadastro de Combo</h1>
        <form action="FrontController?action=CadastrarCombo" method="post">  
            Código:
            <input type="text" name="textCodigo"/><br/>
            Descrição:
            <input type="text" name="textDescricao"/><br/>
            Produto:
            <select name="textCodigoProduto" multiple="multiple">
                <c:forEach items="${produtos}" var="produto">
                    <option value="${produto.getCodProduto()}">${produto.getDescricao()}</option>
                </c:forEach> 
            </select>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
