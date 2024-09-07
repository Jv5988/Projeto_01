<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Usuários</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Lista de Usuários</h2>
        
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="Conta.jsp" class="btn btn-primary">Voltar</a>
    </div>
</body>
</html>
