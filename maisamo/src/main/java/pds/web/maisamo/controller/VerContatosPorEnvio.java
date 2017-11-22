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
import pds.web.maisamo.model.Usuario;

/**
 * Servlet implementation class VerContatosPorEnvio
 */
@WebServlet("/VerContatosPorEnvio")
public class VerContatosPorEnvio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EnvioAlertaContatoFacede eacf = new EnvioAlertaContatoFacede();
	private EnvioAlertaFacede eaf = EnvioAlertaFacede();

    /**
     * Default constructor. 
     */
    public VerContatosPorEnvio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// NÃO IMPLEMENTADO!!!
		HttpSession sessao = request.getSession(true);
		Usuario usuario = sessao.getAttribute("usuario");
		EnvioAlerta envio_alerta = eaf.procurarPorId(request.getParameter(""));
		List<EnvioAlertaContato> contatos_por_envio = eacf.listar(envio_alerta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
