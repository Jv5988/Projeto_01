<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conteúdos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.hidden {
	display: none;
}
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
				<c:forEach var="conteudo" items="${conteudos}">
					<tr>
						<td>${conteudo.id}</td>
						<td>${conteudo.conteudos[0]}</td>
						<!-- Acessando o conteúdo corretamente -->
						<td>
							<form action="Tela_Conteudos" method="post"
								style="display: inline;">
								<input type="hidden" name="action" value="delete"> <input
									type="hidden" name="conteudoId" value="${conteudo.id}">
								<button type="submit" class="btn btn-danger">Excluir</button>
							</form>
							<button class="btn btn-primary edit-btn" data-id="${conteudo.id}" data-content="${conteudo.conteudos[0]}">Editar</button>
							
							<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Editar Conteúdo</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editForm" action="Tela_Conteudos" method="post">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="conteudoId" id="editConteudoId">
                    <div class="mb-3">
                        <label for="novoConteudo" class="form-label">Novo Conteúdo</label>
                        <input type="text" class="form-control" id="novoConteudo" name="novoConteudo">
                    </div>
                    <button type="submit" class="btn btn-primary">Salvar Alterações</button>
                </form>
            </div>
        </div>
    </div>
</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="Dpslogado" method="post">
			<div class="mb-3">
				<input type="text" name="conteudo" class="form-control"
					placeholder="Novo conteúdo" required />
			</div>
			<button type="submit" class="btn btn-success">Adicionar
				Conteúdo</button>
		</form>
	</div>
	<script>
    document.querySelectorAll('.edit-btn').forEach(button => {
        button.addEventListener('click', () => {
            const conteudoId = button.getAttribute('data-id');
            const conteudo = button.getAttribute('data-content');
            document.getElementById('editConteudoId').value = conteudoId;
            document.getElementById('novoConteudo').value = conteudo;
            const editModal = new bootstrap.Modal(document.getElementById('editModal'));
            editModal.show();
        });
    });
</script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>
