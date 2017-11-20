package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.PaginaDAO;
import pds.web.maisamo.model.Pagina;

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
