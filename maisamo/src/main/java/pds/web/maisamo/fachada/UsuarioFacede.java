package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.UsuarioDAO;
import pds.web.maisamo.model.Usuario;

public class UsuarioFacede {
	private UsuarioDAO udao = new UsuarioDAO();
	
	public boolean inserir(Usuario usuario) {
		return udao.inserir(usuario);
	}
	public boolean atualizar(Usuario usuario) {
		return udao.atualizar(usuario);
	}
	public boolean excluir(Usuario usuario) {
		return udao.excluir(usuario);
	}
	public List<Usuario> listar() {
		return udao.listar();
	}
	public boolean procurarNome(String nome) {
		return udao.procurarNome(nome);
	}
	public boolean procurarLogin(String login) {
		return udao.procurarLogin(login);
	}
	public Usuario autenticar(String login, String senha) {
		return udao.autenticar(login, senha);
	}
}
