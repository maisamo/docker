package pds.web.maisamo.model;

import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.EmailException;

public class Enviador {
	private HtmlEmail email;
	private String emailFrom, emailTo, foneTo;
	private String nomeFrom, nomeTo;
	private String assunto, mensagem;
	private String url;
	
	/*
  	public Enviador(Usuario from, Contato to, Alerta alerta, Pagina pagina) {
  		this.nomeFrom = from.getNome();
  		this.nomeTo = to.getNome();
  		this.emailFrom = from.getEmail();
   		this.emailTo = to.getEmail();
   		this.foneTo = to.getFone();
   		this.assunto = alerta.getTitulo();
   		this.mensagem = alerta.getMensagem();
   		this.url = pagina.getUrl();
  	}
	*/
	
	public Enviador(String nomeFrom, String nomeTo, 
			String emailFrom, String emailTo, String foneTo, 
			String assunto, String mensagem, String url) {
		this.nomeFrom = nomeFrom;
  		this.nomeTo = nomeTo;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.foneTo = foneTo;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.url = url;
	}
	
	public Enviador(String nomeFrom, String nomeTo, 
			String emailFrom, String emailTo, 
			String assunto, String mensagem, String url) {
		this.nomeFrom = nomeFrom;
  		this.nomeTo = nomeTo;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.url = url;
	}
	
	public Enviador(String nomeFrom, String nomeTo, 
			String foneTo, String assunto, String mensagem, String url) {
		this.nomeFrom = nomeFrom;
  		this.nomeTo = nomeTo;
		this.foneTo = foneTo;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.url = url;
	}
	
	public void enviarEmail() {
		email = new HtmlEmail();
		try {
			email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
			email.setAuthentication("thiagotierre.lima@gmail.com", "thiago.tierre.de.lima@141090");
			email.addTo(emailTo); // destinatario
			email.setFrom(emailFrom, nomeFrom); // remetente
			email.setSubject(assunto); // assunto do e-mail
			email.setContent("CONTENT", "text/html; charset=utf-8");
			email.setHtmlMsg("<html>"
						+ "<body style=\"background-color: #fff; margin: 67.5% 0; text-align: justify\">"
							+ "<h2>Olá, " + nomeTo + ".</h2>"
							+ "<h3>Esta mensagem é para avisá-lo de que "
								+ "você tem algo importante que deve lembrar."
							+ "</h3>"
							+ "<p style=\"font-size: 20px\">"
								+ mensagem
							+ "Para mais detalhes, acesse o link a seguir."
							+ "</p>"
							+ "<a style=\"font-size: 20px\" href=\"" + url + "\"></a>"
						+ "</body>"
						+ "</html>"); // conteudo do e-mail
			
			email.setTextMsg("Olá, " + nomeTo + ".\nEsta mensagem é para avisá-lo de que "
							+ "você tem algo importante que deve se lembrar.\n"
							+ mensagem
							+ "s\nPara mais detalhes, acesse o link a seguir.\n" + url);
							// caso o e-mail não suporte mensagens no formato html
			email.setSSLOnConnect(true);
			email.send(); // envia o e-mail
			System.out.println("E-mail enviado!");
		} catch (EmailException e) {
			System.out.println(e);
		}
	}
}
