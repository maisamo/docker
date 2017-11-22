package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import pds.web.maisamo.fachada.EnvioAlertaFacede;
import pds.web.maisamo.model.EnvioAlerta;
import pds.web.maisamo.model.Usuario;

/**
 * Servlet implementation class AlertasEnviados
 */
@WebServlet("/AlertasEnviados")
public class AlertasEnviados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EnvioAlertaFacede eaf = new EnvioAlertaFacede();
	
    /**
     * Default constructor. 
     */
    public AlertasEnviados() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession(true);
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		List<EnvioAlerta> alertas_enviados = eaf.listar(usuario);
		
		request.getServletContext().getRequestDispatcher("/alertas_enviados.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
