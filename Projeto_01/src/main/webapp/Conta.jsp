<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Conteúdo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">CMS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            </button>
            </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <hr>
                <h3>Cadastro de Conteúdo</h3>
                <hr>
                <form action="Dpslogado" method="post">
                    <div class="mb-3">
                        <label for="conteudo" class="form-label">Conteúdo</label>
                        <input type="text" class="form-control" id="conteudo" name="conteudo" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <button type="reset" class="btn btn-secondary">Limpar Campo</button>
                    <a href="Index.jsp" class="btn btn-primary">Voltar</a>
                </form>
                <hr>
                <a href="Tela_Conteudos" class="btn btn-info">Mostrar Conteúdos</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
