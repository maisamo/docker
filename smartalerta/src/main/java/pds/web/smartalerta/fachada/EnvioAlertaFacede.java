package pds.web.smartalerta.fachada;

import java.util.List;

import pds.web.smartalerta.DAO.EnvioAlertaDAO;
import pds.web.smartalerta.model.EnvioAlerta;
import pds.web.smartalerta.model.Usuario;

public class EnvioAlertaFacede {
	private EnvioAlertaDAO eadao = new EnvioAlertaDAO();
	
	public boolean inserir(EnvioAlerta envio_alerta) {
		return eadao.inserir(envio_alerta);
	}
	public boolean excluir(EnvioAlerta envio_alerta) {
		return eadao.excluir(envio_alerta);
	}
	public List<EnvioAlerta> listar(Usuario usuario) {
		return eadao.listar(usuario);
	}
	public EnvioAlerta procurarPorId(Long id) {
		return eadao.procurarPorId(id);
	}
}
