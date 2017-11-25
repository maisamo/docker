package pds.web.smartalerta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import pds.web.smartalerta.fachada.AlertaFacede;
import pds.web.smartalerta.fachada.EnvioAlertaContatoFacede;
import pds.web.smartalerta.fachada.EnvioAlertaFacede;
import pds.web.smartalerta.fachada.PaginaFacede;
import pds.web.smartalerta.model.Alerta;
import pds.web.smartalerta.model.Contato;
import pds.web.smartalerta.model.EnvioAlerta;
import pds.web.smartalerta.model.EnvioAlertaContato;
import pds.web.smartalerta.model.Pagina;
import pds.web.smartalerta.model.Usuario;
import pds.web.smartalerta.service.Enviador;

@WebServlet("/EnviarAlerta")
public class EnviarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
		
		HttpSession sessao = request.getSession(true);
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		String[] contatos = request.getParameterValues("enviarPara");
		String alerta = request.getParameter("alerta");
		//Pagina pagina = new Pagina();
		//pagina.addParam("nome=" + contato.getNome);
		//pagina.addParam("&titulo=" + alerta.getTitulo());
		//pagina.addParam("&categoria=" + alerta.getCategoria());
		//pagina.addParam("&mensagem=" + alerta.getMensagem());
		String nomeFrom = usuario.getNome();
		String emailFrom = usuario.getEmail();
		String nomeTo = request.getParameter("nome");
		
		String emailTo = request.getParameter("email");
		String foneTo = request.getParameter("telefone");
		String mensagem = request.getParameter("mensagem");
		String assunto = request.getParameter("tipo_alerta");
		String url = "https://www.youtube.com/";
		Enviador env = new Enviador();
		env.enviarEmail();
		response.sendRedirect("enviar_alerta.jsp");
	}
	
	private void verificarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if (sessao == null) response.sendRedirect("acesso_negado.jsp");
	}
}
