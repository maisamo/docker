package pds.web.smartalerta.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class EnvioAlerta {
	private Long id;
	private LocalDateTime datahora_envio;
	private Alerta alerta;
	
	public EnvioAlerta() {}
	
	public EnvioAlerta(Alerta alerta) {
		this.alerta = alerta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEnvio() {
		return datahora_envio.toLocalDate();
	}
	public LocalTime getHoraEnvio() {
		return datahora_envio.toLocalTime();
	}
	public void setDataHoraEnvio(LocalDateTime datahora_envio) {
		this.datahora_envio = datahora_envio;
	}
	
	public Alerta getAlerta() {
		return alerta;
	}
}
