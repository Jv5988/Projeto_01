<%@ page import="java.util.List"%>
<%@ page import="model.Conteudo"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todos os Conteúdos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h3 class="text-center mb-4">Todos os Conteúdos</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>ID do Usuário</th>
					<th>Conteúdo</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Conteudo> conteudos = (List<Conteudo>) request.getAttribute("conteudos");
				if (conteudos != null) {
					for (Conteudo conteudo : conteudos) {
				%>
				<tr>
					<td><%=conteudo.getId()%></td>
					<td><%=conteudo.getUsuarioId()%></td>
					<td><%=conteudo.getConteudos().get(0)%></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="3" class="text-center">Nenhum conteúdo
						encontrado.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="Index.jsp" class="btn btn-primary">Voltar</a>
	</div>
</body>
</html>
