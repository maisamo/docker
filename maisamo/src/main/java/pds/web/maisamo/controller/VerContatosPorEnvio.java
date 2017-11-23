package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import pds.web.maisamo.fachada.EnvioAlertaContatoFacede;
import pds.web.maisamo.fachada.EnvioAlertaFacede;
import pds.web.maisamo.model.EnvioAlertaContato;
import pds.web.maisamo.model.EnvioAlerta;

@WebServlet("/VerContatosPorEnvio")
public class VerContatosPorEnvio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao = null;
	
	private EnvioAlertaContatoFacede eacf = new EnvioAlertaContatoFacede();
	private EnvioAlertaFacede eaf = new EnvioAlertaFacede();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
		
		Long envio_alerta_id = (Long) request.getAttribute("eaid");
		EnvioAlerta envio_alerta = eaf.procurarPorId(envio_alerta_id);
		List<EnvioAlertaContato> contatos_por_envio = eacf.listar(envio_alerta);
		
		request.setAttribute("contatos_por_envio", contatos_por_envio);
		request.getServletContext().getRequestDispatcher("/alertas_enviados?mostrar=true").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
	}
	
	private void verificarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if (sessao == null) response.sendRedirect("acesso_negado.jsp");
	}
}
