package pds.web.smartalerta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pds.web.smartalerta.fachada.ContatoFacede;
import pds.web.smartalerta.model.Contato;
import pds.web.smartalerta.model.Usuario;

/*
import pds.web.maisamo.fachada.EmailFacede;
import pds.web.maisamo.model.Email;
import pds.web.maisamo.fachada.FoneFacede;
import pds.web.maisamo.model.Fone;
*/

@WebServlet("/AdicionarContato")
public class AdicionarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HttpSession sessao = null;  
	
	private ContatoFacede cf = new ContatoFacede();
	
	/*
	private EmailFacede ef = new EmailFacede();
	private FoneFacede ff = new FoneFacede();
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarSessao(request, response);
		
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
	
	private void verificarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if (sessao == null) response.sendRedirect("acesso_negado.jsp");
	}
}
