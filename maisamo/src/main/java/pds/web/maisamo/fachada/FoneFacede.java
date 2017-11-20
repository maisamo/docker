package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.FoneDAO;
import pds.web.maisamo.model.Fone;
import pds.web.maisamo.model.Contato;

public class FoneFacede {
	private FoneDAO fdao = new FoneDAO();
	
	public boolean inserir(Fone fone) {
		return fdao.inserir(fone);
	}
	public boolean atualizar(Fone fone) {
		return fdao.atualizar(fone);
	}
	public boolean excluir(Fone fone) {
		return fdao.excluir(fone);
	}
	public List<Fone> listar(Contato contato) {
		return fdao.listar(contato);
	}
}
