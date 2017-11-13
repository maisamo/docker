package pds.web.maisamo.model;

import java.time.LocalDateTime;

public class Pagina {
	private StringBuffer url, requestParams;
	private LocalDateTime data_expira;
	
	public Pagina() {
		data_expira = LocalDateTime.now().plusHours(24);
	}
	
	public void addParam(String requestParam) {
		this.requestParams.append(requestParam);
	}
	
	public String getUrl() {
		url.append("localhost:8080/maisamo/AcessarPagina?");
		url.append(requestParams);
		return url.toString();
	}
	
	public LocalDateTime getDataExpira() {
		return data_expira;
	}
}
