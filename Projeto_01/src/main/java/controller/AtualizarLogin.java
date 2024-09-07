package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDao;
import model.Usuario;


@WebServlet("/AtualizarLogin")
public class AtualizarLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UsuarioDao usuarioDao;

    public void init() {
        usuarioDao = new UsuarioDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("senha");
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId != null && email != null && password != null) {
        	int id = userId.intValue();
            Usuario usuario = new Usuario(id, email, password);
            usuarioDao.update(usuario);
            response.sendRedirect("Conta.jsp");
        } else {
            request.setAttribute("errorMessage", "Dados inválidos.");
            request.getRequestDispatcher("AtualizarLogin.jsp").forward(request, response);
        }
    }
}
