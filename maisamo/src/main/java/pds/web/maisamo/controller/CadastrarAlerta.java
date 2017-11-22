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


@WebServlet("/CadastrarAlerta")
public class CadastrarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AlertaFacede af = new AlertaFacede();
	
    public CadastrarAlerta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarUsuario(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarUsuario(request, response);
		
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
		}
		request.setAttribute("valido", valido);
		request.getServletContext().getRequestDispatcher("/cadastrar_alerta.jsp").forward(request, response);
	}
	
	private void verificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object usuario = request.getSession().getAttribute("usuario");
		if (usuario == null) response.sendRedirect("acesso_negado.jsp");
	}
}
