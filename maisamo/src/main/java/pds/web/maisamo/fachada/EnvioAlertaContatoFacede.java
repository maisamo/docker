package pds.web.maisamo.fachada;

import java.util.List;

import pds.web.maisamo.DAO.EnvioAlertaContatoDAO;
import pds.web.maisamo.model.EnvioAlertaContato;
import pds.web.maisamo.model.EnvioAlerta;

public class EnvioAlertaContatoFacede {
	private EnvioAlertaContatoDAO eacdao = new EnvioAlertaContatoDAO();
	
	public boolean inserir(EnvioAlertaContato envio_alerta_contato) {
		return eacdao.inserir(envio_alerta_contato);
	}
	public boolean excluir(EnvioAlertaContato envio_alerta_contato) {
		return eacdao.excluir(envio_alerta_contato);
	}
	public List<EnvioAlertaContato> listar(EnvioAlerta envio_alerta) {
		return eacdao.listar(envio_alerta);
	}
}
