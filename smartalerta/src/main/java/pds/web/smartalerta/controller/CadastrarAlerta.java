package pds.web.smartalerta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.smartalerta.fachada.AlertaFacede;
import pds.web.smartalerta.model.Alerta;
import pds.web.smartalerta.model.Usuario;


@WebServlet("/CadastrarAlerta")
public class CadastrarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HttpSession sessao = null;
    
	private AlertaFacede af = new AlertaFacede();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
		
		boolean valido = true;
		
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		String mensagem = request.getParameter("mensagem");
		
		if (af.procurarTitulo(titulo)) valido = false;
		
		if (valido) {
			Usuario u = (Usuario) sessao.getAttribute("usuario");
			Alerta a = new Alerta(u);
			a.setTitulo(titulo);
			a.setCategoria(categoria);
			a.setMensagem(mensagem);
			af.inserir(a);
		}
		request.setAttribute("valido", valido);
		request.getServletContext().getRequestDispatcher("/cadastrar_alerta.jsp").forward(request, response);
	}
	
	private void verificarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if (sessao == null) response.sendRedirect("acesso_negado.jsp");
	}
}
