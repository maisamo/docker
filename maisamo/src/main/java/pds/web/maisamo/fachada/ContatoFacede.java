package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.ContatoDAO;
import pds.web.maisamo.model.Contato;
import pds.web.maisamo.model.Usuario;

public class ContatoFacede {
	private ContatoDAO cdao = new ContatoDAO();
	
	public boolean inserir(Contato contato) {
		return cdao.inserir(contato);
	}
	public boolean atualizar(Contato contato) {
		return cdao.atualizar(contato);
	}
	public boolean excluir(Contato contato) {
		return cdao.excluir(contato);
	}
	public List<Contato> listar(Usuario usuario) {
		return cdao.listar(usuario);
	}
	public boolean procurarNome(String nome) {
		return cdao.procurarNome(nome);
	}
	public Long getIdPorNome(String nome) {
		return cdao.getIdPorNome(nome);
	}
}
