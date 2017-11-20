package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.EmailDAO;
import pds.web.maisamo.model.Email;
import pds.web.maisamo.model.Contato;

public class EmailFacede {
	private EmailDAO edao = new EmailDAO();
	
	public boolean inserir(Email email) {
		return edao.inserir(email);
	}
	public boolean atualizar(Email email) {
		return edao.atualizar(email);
	}
	public boolean excluir(Email email) {
		return edao.excluir(email);
	}
	public List<Email> listar(Contato contato) {
		return edao.listar(contato);
	}
}
