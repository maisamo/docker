package pds.web.smartalerta.fachada;

import java.util.List;

import pds.web.smartalerta.DAO.PaginaDAO;
import pds.web.smartalerta.model.Pagina;

public class PaginaFacede {
	private PaginaDAO pdao = new PaginaDAO();
	
	public boolean inserir(Pagina pagina) {
		return pdao.inserir(pagina);
	}
	public boolean excluir(Pagina pagina) {
		return pdao.excluir(pagina);
	}
	public List<Pagina> listar() {
		return pdao.listar();
	}
}
