package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import pds.web.maisamo.fachada.AlertaFacede;
import pds.web.maisamo.model.Alerta;
import pds.web.maisamo.model.Usuario;

@WebServlet("/VerAlertas")
public class VerAlertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao = null;
	
	private AlertaFacede af = new AlertaFacede(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		List<Alerta> alertas = af.listar(usuario);
		
		request.setAttribute("alertas", alertas);
		request.getServletContext().getRequestDispatcher("/visualizar_alertas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
	}
	
	private void verificarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if (sessao == null) response.sendRedirect("acesso_negado.jsp");
	}
}
