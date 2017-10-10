package maisamo.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

import maisamo.model.Mensagem;
import maisamo.model.Paciente;
import maisamo.model.TipoMensagem;

/**
 * Servlet implementation class SendMensager
 */
@WebServlet("/SendMensager")
public class SendMensager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleEmail email = null;
       
    public SendMensager() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensagem mensagem = new Mensagem();
		Paciente paciente = new Paciente();
		paciente.setNome(request.getParameter("nome"));
		paciente.setEmail(request.getParameter("email"));
		paciente.setTelefone(request.getParameter("telefone"));
		mensagem.setDescricao(request.getParameter("descricao"));
		mensagem.setTipomensagem(TipoMensagem.valueOf(request.getParameter("tipomensagem")));
		mensagem.setPaciente(paciente);
		
		
		String nomeRemetente = paciente.getNome();
		String emailRemetente = paciente.getEmail();
		String nomeCorrigido = new String(nomeRemetente.getBytes("utf-8"), "UTF-8");
		 
		String assuntoCorrigido = new String(mensagem.getTipomensagem().toString().getBytes("utf-8"), "UTF-8");
		String msgCorrigida = new String(mensagem.getDescricao().getBytes("utf-8"), "utf-8");
		 
		StringBuffer sb = new StringBuffer();
		sb.append("Formulario enviado pela: Ouvidoria");
		sb.append("\n");
		sb.append("Nome: "+nomeCorrigido);
		sb.append("\n");
		sb.append("Assunto: "+assuntoCorrigido);
		sb.append("\n");
		sb.append("Mensagem: "+msgCorrigida);
		
		email = new SimpleEmail(); 
		try {
			email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail 
			email.addTo("thiagotierre.lima@gmail.com", "TESTE JAVA MAIL PDS"); //destinatario
			email.setFrom(emailRemetente, nomeCorrigido); // remetente 
			email.setSubject(assuntoCorrigido); // assunto do e-mail
			email.setContent("CONTENT", "text/html; charset=utf-8");
			email.setMsg(new String(sb.toString().getBytes("utf-8"), "UTF-8")); //conteudo do e-mail
			email.setSSLOnConnect(true);
			email.send(); //envia o e-mail
			System.out.println("NomeCorrigido: "+nomeCorrigido+" AssuntoCorrigido: "+assuntoCorrigido
			+" MensagemCorrigida: "+msgCorrigida);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
