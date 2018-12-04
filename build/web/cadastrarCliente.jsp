<%-- 
    Document   : cadastrarCliente
    Created on : 23/10/2018, 20:11:14
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
        <h1>Cadastro de Clientes</h1>
        <form action="FrontController?action=CadastrarCliente" method="post">
            Código:
            <input type="text" name="textCodigo"/><br/>
            Nome:
            <input type="text" name="textNome"/><br/>
            Rua:
            <input type="text" name="textRua"/><br/>
            Número:
            <input type="text" name="textNumero"/><br/>
            Bairro:
            <input type="text" name="textBairro"/><br/>
            CEP:
            <input type="text" name="textCep"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
