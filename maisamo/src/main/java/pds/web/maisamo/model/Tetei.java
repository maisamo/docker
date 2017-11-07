package pds.web.maisamo.model;

/*import java.sql.Timestamp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;*/

import pds.web.maisamo.DAO.AlertaDAO;

public class Tetei {

	public static void main(String[] args) {
		/*Client client = ClientBuilder.newClient();
		Entity payload = Entity.json("{  'sendSmsRequest': {    'from': 'Remetente',    'to': '5584994966306',    'schedule': '2014-08-22T14:55:00',    'msg': 'Mensagem de teste',    'callbackOption': 'NONE',    'id': '002',    'aggregateId': '1111',    'flashSms': true  }}");
		Response response = client.target("https://api-rest.zenvia360.com.br/services/send-sms")
		  .request(MediaType.APPLICATION_JSON_TYPE)
		  .header("Authorization", "Basic YWRtaW46YWRtaW4=")
		  .header("Accept", "application/json")
		  .post(payload);

		System.out.println("status: " + response.getStatus());
		System.out.println("headers: " + response.getHeaders());
		System.out.println("body:" + response.readEntity(String.class));*/
		
		Alerta alerta =  new Alerta();
		alerta.setEmail("teste@gmail.com");
		alerta.setTelefone("84994966306");
		alerta.setTipoalerta(1L);
		alerta.setFrequencia(19);
		AlertaDAO dao = new AlertaDAO();
		
		try {
			dao.cadastrar(alerta);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
