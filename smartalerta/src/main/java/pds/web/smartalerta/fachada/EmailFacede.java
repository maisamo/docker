package pds.web.smartalerta.fachada;

import java.util.List;

import pds.web.smartalerta.DAO.EmailDAO;
import pds.web.smartalerta.model.Contato;
import pds.web.smartalerta.model.Email;

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
