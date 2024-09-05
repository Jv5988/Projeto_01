package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConteudoDao;
import model.Conteudo;

@WebServlet("/Tela_Conteudos")
public class Tela_Conteudos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ConteudoDao conteudoDao;

    public void init() {
        conteudoDao = new ConteudoDao();
    }

    public Tela_Conteudos() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId != null) {
            List<Conteudo> conteudos = conteudoDao.listarConteudos(userId);
            request.setAttribute("conteudos", conteudos);
        } else {
            request.setAttribute("errorMessage", "Usuário não autenticado.");
        }

        request.getRequestDispatcher("Conteudos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer conteudoId = Integer.parseInt(request.getParameter("conteudoId"));

        if ("delete".equals(action)) {
            conteudoDao.excluirConteudo(conteudoId);
        } else if ("edit".equals(action)) {
            String novoConteudo = request.getParameter("novoConteudo");
            conteudoDao.atualizarConteudo(conteudoId, novoConteudo);
        }

        response.sendRedirect("Tela_Conteudos");
    }
}
