package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.AcessoPaginaDAO;
import pds.web.maisamo.model.AcessoPagina;
import pds.web.maisamo.model.Pagina;

public class AcessoPaginaFacede {
	private AcessoPaginaDAO apdao = new AcessoPaginaDAO();
	
	public boolean inserir(AcessoPagina acesso_pagina) {
		return apdao.inserir(acesso_pagina);
	}
	public boolean atualizar(AcessoPagina acesso_pagina) {
		return apdao.atualizar(acesso_pagina);
	}
	public boolean excluir(AcessoPagina acesso_pagina) {
		return apdao.excluir(acesso_pagina);
	}
	public List<AcessoPagina> listar(Pagina pagina) {
		return apdao.listar(pagina);
	}
}
