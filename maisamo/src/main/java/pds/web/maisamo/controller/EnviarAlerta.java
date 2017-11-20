package pds.web.maisamo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

import pds.web.maisamo.fachada.AlertaFacede;
import pds.web.maisamo.fachada.PaginaFacede;
import pds.web.maisamo.fachada.EnvioAlertaFacede;
import pds.web.maisamo.fachada.EnvioAlertaContatoFacede;

import pds.web.maisamo.model.Usuario;
import pds.web.maisamo.model.Alerta;
import pds.web.maisamo.model.Contato;
import pds.web.maisamo.model.Pagina;
import pds.web.maisamo.model.EnvioAlerta;
import pds.web.maisamo.model.EnvioAlertaContato;

import pds.web.maisamo.service.Enviador;

@WebServlet("/EnviarAlerta")
public class EnviarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		String[] contatos = request.getParameterValues("enviarPara");
		String alerta = request.getParameter("alerta");
		//Pagina pagina = new Pagina();
		//pagina.addParam("nome=" + contato.getNome);
		//pagina.addParam("&titulo=" + alerta.getTitulo());
		//pagina.addParam("&categoria=" + alerta.getCategoria());
		//pagina.addParam("&mensagem=" + alerta.getMensagem());
		String nomeFrom = "Salud!";
		String nomeTo = request.getParameter("nome");
		String emailFrom = "nao_responder@salud.com.br";
		String emailTo = request.getParameter("email");
		String foneTo = request.getParameter("telefone");
		String mensagem = request.getParameter("mensagem");
		String assunto = request.getParameter("tipo_alerta");
		String url = "https://www.youtube.com/";
		
		nomeTo = new String(nomeTo.getBytes("utf-8"), "UTF-8");
		assunto = new String(assunto.getBytes("utf-8"), "UTF-8");
		mensagem = new String(mensagem.getBytes("utf-8"), "utf-8");
		Enviador env = new Enviador();
		env.enviarEmail();
		response.sendRedirect("enviarAlerta.jsp");
	}

}
