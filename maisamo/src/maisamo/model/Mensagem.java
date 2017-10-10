package maisamo.model;

public class Mensagem {
	private Long id;
	private String descricao;
	private TipoMensagem tipomensagem;
	private Paciente paciente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoMensagem getTipomensagem() {
		return tipomensagem;
	}
	public void setTipomensagem(TipoMensagem tipomensagem) {
		this.tipomensagem = tipomensagem;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}