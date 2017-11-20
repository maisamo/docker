package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.maisamo.fachada.AlertaFacede;
import pds.web.maisamo.model.Alerta;
import pds.web.maisamo.model.Usuario;


@WebServlet("/CriarAlerta")
public class CadastrarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AlertaFacede af = new AlertaFacede();
	
    public CadastrarAlerta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);
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
			
			response.sendRedirect("cadastrar_alerta.jsp");
		} else {
			response.sendRedirect("cadastrar_alerta.jsp");
		}
	}
}
