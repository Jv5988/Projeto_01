package controller;

import dao.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirUsuario")
public class ExcluirUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        System.out.println("teste: "+userId);

        if (userId != null) {
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.delete(userId);
         
            request.getSession().invalidate();

            response.sendRedirect("Index.jsp");
        } else {
            request.setAttribute("errorMessage", "Usuário não autenticado.");
            request.getRequestDispatcher("Index.jsp").forward(request, response);
        }
    }
}
