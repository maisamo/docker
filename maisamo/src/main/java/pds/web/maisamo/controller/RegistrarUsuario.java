package pds.web.maisamo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds.web.maisamo.fachada.UsuarioFacede;
import pds.web.maisamo.model.Usuario;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioFacede uf = new UsuarioFacede();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean valido = true;
		
		String nome = request.getParameter("registroNome");
		String email = request.getParameter("registroEmail");
		String login = request.getParameter("registroUsuario");
		String senha = request.getParameter("registroSenha");
		
		if (uf.procurarNome(nome) || uf.procurarLogin(login)) valido = false;
				
		if (valido) {
			Usuario u = new Usuario();
			u.setNome(nome);
			u.setLogin(login);
			u.setSenha(senha);
			u.setEmail(email);
			
			uf.inserir(u);
			
			response.sendRedirect("login.html");
		} else {
			response.sendRedirect("registro.html");
		}
	}

}
