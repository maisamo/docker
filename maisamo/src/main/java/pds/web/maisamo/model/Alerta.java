package pds.web.maisamo.model;

public class Alerta {
	private String titulo, mensagem, categoria;
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
