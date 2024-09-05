
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Conteúdos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .hidden { display: none; }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1>Meus Conteúdos</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Conteúdo</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody id="conteudoTable">
                <c:forEach var="conteudo" items="${conteudos}"> <!--Isso aqui era pra mostrar todos os conteudos do usuario, mas n vai, tem que fazer de outro jeito que eu num sei-->
                    <tr data-id="${conteudo.id}">
                        <td>${conteudo.id}</td>
                        <td>${conteudo.conteudo}</td>
                        <td>
                            <form action="Tela_Conteudos" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="conteudoId" value="${conteudo.id}">
                                <button type="submit" class="btn btn-danger btn-sm">Excluir</button>
                            </form>
                            <form action="Tela_Conteudos" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="conteudoId" value="${conteudo.id}">
                                <input type="text" name="novoConteudo" class="form-control d-inline" placeholder="Editar" style="width:auto;">
                                <button type="submit" class="btn btn-primary btn-sm">Editar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="Dpslogado" method="post">
            <div class="mb-3">
                <input type="text" name="conteudo" class="form-control" placeholder="Novo conteúdo" required />
            </div>
            <button type="submit" class="btn btn-success">Adicionar Conteúdo</button>
        </form>
    </div>
</body>
</html>
