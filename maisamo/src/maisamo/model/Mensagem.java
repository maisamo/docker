package maisamo.model;

public class Mensagem {
	private String id;
	private String descricao;
	private TipoMensagem tipomensagem;
	private Paciente paciente;
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setTipomensagem(TipoMensagem tipomensagem) {
		this.tipomensagem = tipomensagem;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public TipoMensagem getTipomensagem() {
		return tipomensagem;
	}
	public Paciente getPaciente() {
		return paciente;
	}
}