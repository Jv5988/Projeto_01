package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConteudoDao;
import model.Conteudo;

@WebServlet("/MostrarTodosConteudos")
public class MostrarTodosConteudos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConteudoDao conteudoDao;

    public void init() {
        conteudoDao = new ConteudoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Conteudo> conteudos = conteudoDao.listarTodosConteudos();
        request.setAttribute("conteudos", conteudos);

        request.getRequestDispatcher("TodosConteudos.jsp").forward(request, response);
    }
}
