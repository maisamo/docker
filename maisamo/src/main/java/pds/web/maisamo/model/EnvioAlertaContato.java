package pds.web.maisamo.model;

public class EnvioAlertaContato {
	private Long id;
	private Contato contato;
	private EnvioAlerta envio_alerta;

	public EnvioAlertaContato(Contato contato, EnvioAlerta envio_alerta) {
		this.contato = contato;
		this.envio_alerta = envio_alerta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public EnvioAlerta getEnvioAlerta() {
		return envio_alerta;
	}
}
