package pds.web.maisamo.model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pagina {
	private Long id;
	private StringBuffer url, params;
	private LocalDateTime datahora_expira;
	private Alerta alerta;
	private Usuario usuario;
	private Contato contato;
	
	public Pagina(Alerta alerta, Usuario usuario, Contato contato) {
		this.alerta = alerta;
		this.usuario = usuario;
		this.contato = contato;
		datahora_expira = LocalDateTime.now().plusHours(24);
	}
	
	public String getUrl() {
		url.append("localhost:8080/maisamo/AcessarPagina?");
		url.append(getParams());
		return url.toString();
	}
	private String getParams() {
		params.append("from=" + usuario.getNome());
		params.append("&to=" + contato.getNome());
		params.append("&titulo=" + alerta.getTitulo());
		params.append("&categoria=" + alerta.getCategoria());
		return params.toString();
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	public LocalDate getDataExpira() {
		return datahora_expira.toLocalDate();
	}
	public LocalTime getHoraExpira() {
		return datahora_expira.toLocalTime();
	}
	public void setDataHoraExpira(LocalDateTime datahora_expira) {
		this.datahora_expira = datahora_expira;
	}
	
	public boolean expirou() {
		return LocalDateTime.now().compareTo(datahora_expira) > 0;
	}
	
	public Alerta getAlerta() {
		return alerta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Contato getContato() {
		return contato;
	}
}
