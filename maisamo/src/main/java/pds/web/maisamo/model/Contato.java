package pds.web.maisamo.model;

public class Contato extends Pessoa {
	private Long id;
	private String email, fone;
	private Usuario usuario;
	
	public Contato() {}
	
	public Contato(Usuario usuario) {
		this.usuario = usuario;
	}
	
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
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}