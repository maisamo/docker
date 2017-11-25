package pds.web.smartalerta.fachada;

import java.util.List;

import pds.web.smartalerta.DAO.UsuarioDAO;
import pds.web.smartalerta.model.Usuario;

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
	public boolean procurar(String valor, String coluna) {
		return udao.procurar(valor, coluna);
	}
	public Usuario autenticar(String login, String senha) {
		return udao.autenticar(login, senha);
	}
}
