<%-- 
    Document   : cadastrarProduto
    Created on : 23/10/2018, 20:11:33
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
        <h1>Cadastro de Produto</h1>
        <form action="FrontController?action=CadastrarProduto" method="post">
            Código:
            <input type="text" name="textCodigo"/><br/>   
            Descrição:
            <input type="text" name="textDescricao"/><br/>
            Preço:
            <input type="text" name="textPreco"/><br/>
            Estabelecimento:
            <select name="textCodigoEstabelecimento">
                <c:forEach items="${estabelecimentos}" var="estabelecimento">
                    <option value="${estabelecimento.getCodEstabelecimento()}">${estabelecimento.getNome()}</option>
                </c:forEach> 
            </select>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
