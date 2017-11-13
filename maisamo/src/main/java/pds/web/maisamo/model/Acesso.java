package pds.web.maisamo.model;

import java.time.LocalDateTime;

public class Acesso {
	private LocalDateTime data_acesso;
	private TipoPessoa tipo_pessoa;
	
	public void setDataAcesso(LocalDateTime data_acesso) {
		this.data_acesso = data_acesso;
	}
	
	public void setTipoPessoa(TipoPessoa tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}
	
	public LocalDateTime getDataAcesso() {
		return this.data_acesso;
	}
	
	public TipoPessoa getTipoPessoa() {
		return this.tipo_pessoa;
	}
}
