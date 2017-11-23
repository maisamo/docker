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

/**
 * Servlet implementation class VerAlertas
 */
@WebServlet("/VerAlertas")
public class VerAlertas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AlertaFacede af = new AlertaFacede(); 
	
    /**
     * Default constructor. 
     */
    public VerAlertas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession(true);
		Usuario usuario = sessao.getAttribute("usuario");
		List<Alerta> alertas = af.listar(usuario);
		
		request.getServletContext().getRequestDispatcher("/visualizar_alertas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}