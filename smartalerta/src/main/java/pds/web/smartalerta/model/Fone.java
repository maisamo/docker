package pds.web.smartalerta.model;

public class Fone {
	private Long id;
	private String fone;
	private Contato contato;
	
	public Fone() {}
	
	public Fone(Contato contato) {
		this.contato = contato;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public Contato getContato() {
		return contato;
	}
}
