package pds.web.smartalerta.model;

public class Alerta {
	private String titulo, mensagem, categoria;
	private Long id;
	private Usuario usuario;
	
	public Alerta() {}
	
	public Alerta(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
