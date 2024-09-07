package controller;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConteudoDao;
import model.Conteudo;

@WebServlet("/Dpslogado")
public class Dpslogado extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConteudoDao conteudoDao;

    public void init() {
        conteudoDao = new ConteudoDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conteudo = request.getParameter("conteudo");
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId != null && conteudo != null && !conteudo.trim().isEmpty()) {
            Conteudo novoConteudo = new Conteudo(userId, Collections.singletonList(conteudo));
            conteudoDao.criarConteudo(novoConteudo);
            request.getSession().setAttribute("successMessage", "Conteúdo adicionado com sucesso!");
        } else {
            request.getSession().setAttribute("errorMessage", "Conteúdo não pode ser vazio.");
        }

        response.sendRedirect("Tela_Conteudos");
    }
}
