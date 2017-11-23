package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.maisamo.fachada.AcessoPaginaFacede;
import pds.web.maisamo.model.AcessoPagina;

import java.time.LocalDateTime;

@WebServlet("/AcessarPagina")
public class AcessarPagina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcessoPaginaFacede apf = new AcessoPaginaFacede();		
		AcessoPagina acesso_pagina = new AcessoPagina();
		acesso_pagina.setDataHoraAcesso(LocalDateTime.now());
		apf.inserir(acesso_pagina);
		
		HttpSession sessao = request.getSession(true);
		sessao.setAttribute("from", request.getParameter("from"));
		sessao.setAttribute("to", request.getParameter("to"));
		sessao.setAttribute("titulo", request.getParameter("titulo"));
		sessao.setAttribute("categoria", request.getParameter("categoria"));
		sessao.setAttribute("mensagem", request.getParameter("mensagem"));
		
		response.sendRedirect("acesso.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
