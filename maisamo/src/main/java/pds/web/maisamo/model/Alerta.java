package pds.web.maisamo.model;

import java.time.LocalDate;

public class Alerta {
	private Long id;
	private String email;
	private String telefone;
	private LocalDate log_date = LocalDate.now();
	private Integer frequencia;
	private Long tipoalerta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getLog_date() {
		return log_date;
	}
	public Integer getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}
	public Long getTipoalerta() {
		return tipoalerta;
	}
	public void setTipoalerta(Long tipoalerta) {
		this.tipoalerta = tipoalerta;
	}
	
}