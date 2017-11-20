package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.AlertaDAO;
import pds.web.maisamo.model.Alerta;
import pds.web.maisamo.model.Usuario;

public class AlertaFacede {
	private AlertaDAO adao = new AlertaDAO();
	
	public boolean inserir(Alerta alerta) {
		return adao.inserir(alerta);
	}
	public boolean atualizar(Alerta alerta) {
		return adao.atualizar(alerta);
	}
	public boolean excluir(Alerta alerta) {
		return adao.excluir(alerta);
	}
	public List<Alerta> listar(Usuario usuario) {
		return adao.listar(usuario);
	}
	public List<Alerta> listarCategoria(String categoria) {
		return adao.listarCategoria(categoria);
	}
	public boolean procurarTitulo(String titulo) {
		return adao.procurarTitulo(titulo);
	}
}
