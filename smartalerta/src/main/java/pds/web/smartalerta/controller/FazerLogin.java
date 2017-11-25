package pds.web.smartalerta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.smartalerta.fachada.UsuarioFacede;
import pds.web.smartalerta.model.Usuario;

@WebServlet("/FazerLogin")
public class FazerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao = null;
	
	private UsuarioFacede uf = new UsuarioFacede();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Vai CUrintia!");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean valido = false;
		
		String login = request.getParameter("loginUsuario");
		String senha = request.getParameter("loginSenha");
		
		System.out.println(login + " " + senha);		
		Usuario u = uf.autenticar(login, senha);
		
		if (u != null) {
			sessao = request.getSession(true);
			sessao.setAttribute("usuario", u);
			response.sendRedirect("cadastrar_alerta.jsp");
		} else {
			request.setAttribute("valido", valido);
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
