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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String senha = request.getParameter("password");

	    boolean validar_user = usuarioDao.login(email, senha);

	    if (validar_user) {
	        request.getSession().setAttribute("usuario", email);
	        response.sendRedirect("Conta.jsp");
	    } else {
	        request.setAttribute("errorMessage", "Email ou senha incorretos.");
	        request.getRequestDispatcher("Index.jsp").forward(request, response);
	    }
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
