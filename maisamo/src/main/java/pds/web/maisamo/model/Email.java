package pds.web.maisamo.model;

public class Email {
	private Long id;
	private String email;
	private Contato contato;
	
	public Email() {}
	
	public Email(Contato contato) {
		this.contato = contato;
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
	
	public Contato getContato() {
		return contato;
	}
}
