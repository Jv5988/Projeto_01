package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;

@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;

	public void init() {
		usuarioDao = new UsuarioDao();
	}
       
	public Usuario() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("password");

		Integer validar_user = usuarioDao.login(email, senha);

		if (validar_user != null) {
			request.getSession().setAttribute("userId", validar_user);
			response.sendRedirect("Conta.jsp");
		} else {
			request.setAttribute("errorMessage", "Email ou senha incorretos.");
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

		if (userId != null) {
            response.getWriter().append("ID do usuário na sessão: ").append(userId.toString());
        } else {
            response.getWriter().append("Nenhum usuário está logado.");
        }
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
