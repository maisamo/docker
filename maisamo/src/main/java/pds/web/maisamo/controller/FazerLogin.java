package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.maisamo.fachada.UsuarioFacede;
import pds.web.maisamo.model.Usuario;

/**
 * Servlet implementation class FazerLogin
 */
@WebServlet("/FazerLogin")
public class FazerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioFacede uf = new UsuarioFacede();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FazerLogin() {
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
		HttpSession sessao = request.getSession(true);
		boolean valido = false;
		
		String login = request.getParameter("loginUsuario");
		String senha = request.getParameter("loginSenha");
		
		Usuario u = uf.autenticar(login, senha);
		
		if (u != null) {
			sessao.setAttribute("usuario", u);
			valido = true;
		}
		
		if (valido)
			response.sendRedirect("cadastrar_alerta.jsp");
		else
			response.sendRedirect("login.html");
	}

}
