package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;

@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDao usuarioDao = new UsuarioDao();
		List<model.Usuario> usuarios = usuarioDao.readAll();

		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
	}

}
