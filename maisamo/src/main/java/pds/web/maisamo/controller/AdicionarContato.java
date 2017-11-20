package pds.web.maisamo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.maisamo.fachada.ContatoFacede;
import pds.web.maisamo.model.Usuario;
import pds.web.maisamo.model.Contato;
import pds.web.maisamo.fachada.EmailFacede;
import pds.web.maisamo.model.Email;
import pds.web.maisamo.fachada.FoneFacede;
import pds.web.maisamo.model.Fone;

/**
 * Servlet implementation class NovoContato
 */
@WebServlet("/AdicionarContato")
public class AdicionarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ContatoFacede cf = new ContatoFacede();
	private EmailFacede ef = new EmailFacede();
	private FoneFacede ff = new FoneFacede();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarContato() {
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
		boolean valido = true;
		
		String nome = request.getParameter("contatoNome");
		String email = request.getParameter("contatoEmail");
		String fone = request.getParameter("contatoFone");
		
		if (cf.procurarNome(nome)) valido = false;
				
		if (valido) {
			//Criando contato
			Usuario u = (Usuario) sessao.getAttribute("usuario");
			Contato c = new Contato(u);
			c.setNome(nome);
			c.setEmail(email);
			c.setFone(fone);
			cf.inserir(c);
			
			/*
			Long id = cf.getIdPorNome(nome);
			c.setId(id);
			
			//Criando email
			Email e = new Email(c);
			e.setEmail(email);
			ef.inserir(e);
			
			//Criando telefone
			Fone f = new Fone(c);
			f.setFone(fone);
			ff.inserir(f);
			*/
		} 
		request.setAttribute("valido", valido);
		request.getServletContext().getRequestDispatcher("/adicionar_contato").forward(request, response);
	}
}
