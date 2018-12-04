<%-- 
    Document   : listarCombo
    Created on : 30/10/2018, 12:27:21
    Author     : dccosta2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iFood</title>
    </head>
    <body>
        <h1>Listar Combo</h1>

        <form action="FrontController?action=CriarCombo" method="post">
            <button type="submit">Cadastrar</button>
        </form>

        <table>
            <thead>
            <th>Código</th>
            <th>Descrição</th>
        </thead>
        <tbody>
        <c:forEach var="combo" items="${combos}">
            <tr>
                <td>${combo.getCodCombo()}</td>
                <td>${combo.getDescricao()}</td>
            </tr>
        </c:forEach>
    </tbody>
</body>
</html>
