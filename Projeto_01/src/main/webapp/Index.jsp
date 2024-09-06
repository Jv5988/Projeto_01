<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CMS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<h3 class="text-center mb-4">Login</h3>
				<form action="Usuario" method="post">
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							required>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Senha</label> <input
							type="password" class="form-control" id="password"
							name="password" required>
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
					 <div class="d-grid mt-2">
                        <a href="criarconta.jsp" class="btn btn-secondary">Criar Conta</a>
                    </div>
					<div class="text-danger mt-2">
                    <% 
                        String errorMessage = (String) request.getAttribute("errorMessage");
                        if (errorMessage != null) {
                            out.print(errorMessage);
                        }
                    %>
                </div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>