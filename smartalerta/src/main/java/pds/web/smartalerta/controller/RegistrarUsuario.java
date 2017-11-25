package pds.web.smartalerta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds.web.smartalerta.fachada.UsuarioFacede;
import pds.web.smartalerta.model.Usuario;

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
		boolean nome_valido = true;
		boolean login_valido = true;
		boolean email_valido = true;
		
		String nome = request.getParameter("registroNome");
		String email = request.getParameter("registroEmail");
		String login = request.getParameter("registroUsuario");
		String senha = request.getParameter("registroSenha");
		
		if (uf.procurar(nome,"nome")) nome_valido = false;
		if (uf.procurar(login,"login")) login_valido = false;
		if (uf.procurar(email,"email")) email_valido = false;
				
		if (nome_valido && login_valido && email_valido) {
			Usuario u = new Usuario();
			u.setNome(nome);
			u.setLogin(login);
			u.setSenha(senha);
			u.setEmail(email);
			
			uf.inserir(u);
		}
		request.setAttribute("nome_valido", nome_valido);
		request.setAttribute("login_valido", login_valido);
		request.setAttribute("email_valido", email_valido);
		request.getServletContext().getRequestDispatcher("/registro.jsp").forward(request, response);
	}
}
