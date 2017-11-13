package pds.web.maisamo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds.web.maisamo.model.Enviador;


@WebServlet("/EnviarAlerta")
public class EnviarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Usuario usuario = Sistema.getUsuario();
		//Contato contato = (Contato) request.getParameter("enviarPara");
		//Alerta alerta = (Alerta) request.getParameter("alerta");
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
		Enviador env = new Enviador(nomeFrom, nomeTo, emailFrom, emailTo, foneTo, assunto, mensagem, url);
		env.enviarEmail();
		/*
		Mensagem mensagem = new Mensagem();
		paciente.setNome(request.getParameter("nome"));
		paciente.setEmail(request.getParameter("email"));
		paciente.setTelefone(request.getParameter("telefone"));
		mensagem.setDescricao(request.getParameter("mensagem"));
		mensagem.setTipomensagem(TipoMensagem.valueOf(request.getParameter("tipomensagem")));
		mensagem.setPaciente(paciente);

		

		StringBuffer sb = new StringBuffer();
		sb.append("Olá, " + paciente.getNome());
		sb.append("\n\n\n");
		sb.append("Esta mensagem é um alerta de \"" + assuntoCorrigido + "\"");
		sb.append("\n\n");
		sb.append(msgCorrigida);
		*/
		response.sendRedirect("index.html");
	}

}
