package pds.web.smartalerta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import pds.web.smartalerta.fachada.EnvioAlertaFacede;
import pds.web.smartalerta.model.EnvioAlerta;
import pds.web.smartalerta.model.Usuario;

@WebServlet("/AlertasEnviados")
public class AlertasEnviados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao = null;
	private EnvioAlertaFacede eaf = new EnvioAlertaFacede();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		List<EnvioAlerta> alertas_enviados = eaf.listar(usuario);
		
		request.setAttribute("alertas_enviados", alertas_enviados);
		request.getServletContext().getRequestDispatcher("/alertas_enviados.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
	}
	
	private void verificarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if (sessao == null) response.sendRedirect("acesso_negado.jsp");
	}
}
