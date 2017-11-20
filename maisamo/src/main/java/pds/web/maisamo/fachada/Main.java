package pds.web.maisamo.fachada;

import java.util.List;
import java.util.Scanner;

import pds.web.maisamo.model.Usuario;
import pds.web.maisamo.service.Enviador;

public class Main {
	public static void main(String[] args) {
		Enviador env = new Enviador();
		env.setNomeFrom("Salud!");
		env.setNomeTo("Victor");
		env.setEmailFrom("nao-responder@salud.com.br");
		env.setEmailTo("victorwdr@gmail.com");
		env.setAssunto("IMPLEMENTAÇÃO");
		env.setTitulo("Changes need to be made");
		env.setMensagem("Então cara como eu disse, mudanças precisam ser feitas, entende?\n"
				+ "Não quero ser chato mas o mundo é feito disso. Então se liga, cara. Seja a mudança que você quer ver.\n"
				+ "Valeu. Até mais.");
		env.setUrl("https://youtube.com/");
		env.enviarEmail();
		/*
		UsuarioFacede uf = new UsuarioFacede();
		List<Usuario> usuarios = uf.listar();
		Scanner scan = new Scanner(System.in);
		String login = scan.nextLine();
		String senha = scan.nextLine();
		scan.close();
		
		for (Usuario usu: usuarios) {
			if (usu.getLogin().equals(login) && usu.getSenha().equals(senha))
				System.err.println("Logged in!");
			else
				System.err.println("Nome de usuário e/ou senha incorretos!");
		}
		
		Usuario u = usuarios.get(0);
		u.setNome("pds.web");
		u.setLogin("pdsweb");
		
		if (uf.atualizar(u)) System.out.println("Vai Curintia!");
		uf.listar().forEach(usu -> 
			System.out.println("   id : " + usu.getId() + 
							"\n nome : " + usu.getNome() + 
							"\nlogin : " + usu.getLogin() + 
							"\nsenha : " + usu.getSenha()
							)
			);
		*/
	}
}
