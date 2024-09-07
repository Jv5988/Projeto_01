<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Atualizar Login</h2>
        <form action="AtualizarLogin" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Novo Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Nova Senha</label>
                <input type="password" class="form-control" id="senha" name="senha" required>
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
            <a href="Conta.jsp" class="btn btn-secondary">Voltar</a>
        </form>
    </div>
</body>
</html>