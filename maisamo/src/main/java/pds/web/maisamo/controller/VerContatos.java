package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import pds.web.maisamo.fachada.ContatoFacede;
import pds.web.maisamo.model.Contato;
import pds.web.maisamo.model.Usuario;

/**
 * Servlet implementation class VerContatos
 */
@WebServlet("/VerContatos")
public class VerContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoFacede cf = new ContatoFacede();
	
    /**
     * Default constructor. 
     */
    public VerContatos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession(true);
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		List<Contato> contatos = cf.listar(usuario);
		
		request.getServletContext().getRequestDispatcher("/visualizar_contatos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
