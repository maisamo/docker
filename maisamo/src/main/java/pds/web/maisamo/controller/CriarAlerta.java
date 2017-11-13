package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pds.web.maisamo.DAO.AlertaDAO;
import pds.web.maisamo.model.Alerta;


@WebServlet("/CriarAlerta")
public class CriarAlerta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CriarAlerta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alerta alerta = new Alerta();
		AlertaDAO dao = new AlertaDAO();
		alerta.setTitulo(request.getParameter("titulo"));
		alerta.setCategoria(request.getParameter("categoria"));
		alerta.setMensagem(request.getParameter("mensagem"));
		try {
			dao.cadastrar(alerta);
			response.sendRedirect("cadastrarAlerta.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
