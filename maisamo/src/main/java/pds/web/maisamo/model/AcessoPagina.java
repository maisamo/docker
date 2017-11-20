package pds.web.maisamo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class AcessoPagina {
	private Long id;
	private LocalDateTime datahora_acesso;
	private Pagina pagina;
	
	public AcessoPagina() {}
	
	public AcessoPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDataAcesso() {
		return datahora_acesso.toLocalDate();
	}
	public LocalTime getHoraAcesso() {
		return datahora_acesso.toLocalTime();
	}
	public void setDataHoraAcesso(LocalDateTime datahora_acesso) {
		this.datahora_acesso = datahora_acesso;
	}
	
	public Pagina getPagina() {
		return pagina;
	}
}
