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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		if (userId != null) {
			List<Conteudo> conteudos = conteudoDao.listarConteudos(userId);
			request.setAttribute("conteudos", conteudos);
		} else {
			request.setAttribute("errorMessage", "Usuário não autenticado.");
		}

		request.getRequestDispatcher("Conteudos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			Integer conteudoId = Integer.parseInt(request.getParameter("conteudoId"));
			 System.out.println("ID do conteúdo recebido: " + conteudoId);

			if ("delete".equals(action)) {
				 System.out.println("Chamando excluirConteudo com ID: " + conteudoId);
				conteudoDao.excluirConteudo(conteudoId);
				System.out.println(conteudoId);
			} else if ("edit".equals(action)) {
				String novoConteudo = request.getParameter("novoConteudo");
				System.out.println("Conteúdo atualizado: " + conteudoId + " - Novo Conteúdo: " + novoConteudo);
				conteudoDao.atualizarConteudo(conteudoId, novoConteudo);

			}
		} catch (NumberFormatException e) {
			System.out.println("O erro está no id " + e);
		} catch (Exception e) {
			System.out.println("Erro na classe Tela_Conteudos: " + e.getMessage());
		}

		response.sendRedirect("Tela_Conteudos");
	}
}
