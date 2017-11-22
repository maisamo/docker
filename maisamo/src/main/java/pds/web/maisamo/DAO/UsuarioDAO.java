package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.ConexaoBanco;
import pds.web.maisamo.service.Seguranca;
import pds.web.maisamo.model.Usuario;

public class UsuarioDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado;
	
	public boolean inserir(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome,login,senha,email) values (?,?,?,?)";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, Seguranca.Criptografar(usuario.getSenha()));
			preparador.setString(4, usuario.getEmail());
			preparador.execute();
			
			resultado = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public boolean atualizar(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, email = ? where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, Seguranca.Criptografar(usuario.getSenha()));
			preparador.setString(4, usuario.getEmail());
			preparador.setLong(5, usuario.getId());
			preparador.execute();
			resultado = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public boolean excluir(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, usuario.getId());
			preparador.execute();
			resultado = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuario ORDER BY id DESC";
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			
			rs = preparador.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				lista.add(usuario);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return lista;
	}
	
	public boolean procurar(String valor, String coluna) {
		String sql = "SELECT * FROM usuario WHERE " + coluna + " = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, valor);
			
			rs = preparador.executeQuery();
			
			if (rs.next()) resultado = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public Usuario autenticar(String login, String senha) {
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
		
		Usuario usuario = null;
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setString(2, Seguranca.Criptografar(senha));
			
			rs = preparador.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return usuario;
	}
}
