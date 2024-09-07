package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;

@WebServlet("/criarconta")
public class CriarConta extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;

    public void init() {
        usuarioDao = new UsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        Usuario usuario = new Usuario(email, senha);
        usuarioDao.create(usuario);

        response.sendRedirect("Index.jsp");
    }
}
