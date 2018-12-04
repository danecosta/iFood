<%-- 
    Document   : cadastrarEstabelecimento
    Created on : 29/10/2018, 19:22:44
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
        <h1>Cadastro de Estabelecimentos</h1>
        <form action="FrontController?action=CadastrarEstabelecimento" method="post">
            Código:
            <input type="text" name="textCodigo"/><br/>   
            Nome:
            <input type="text" name="textNome"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
