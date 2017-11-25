package pds.web.smartalerta.fachada;

import java.util.List;

import pds.web.smartalerta.DAO.EnvioAlertaContatoDAO;
import pds.web.smartalerta.model.EnvioAlerta;
import pds.web.smartalerta.model.EnvioAlertaContato;

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
