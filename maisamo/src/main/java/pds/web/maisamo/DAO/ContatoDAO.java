package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.ConexaoBanco;
import pds.web.maisamo.model.Contato;
import pds.web.maisamo.model.Usuario;

public class ContatoDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado = false;
	
	public boolean inserir(Contato contato)	{
		String sql = "INSERT INTO contato (nome,email,fone,usuario_id) values (?,?,?,?)";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, contato.getNome());
			preparador.setString(2, contato.getEmail());
			preparador.setString(3, contato.getFone());
			preparador.setLong(4, contato.getUsuario().getId());
			preparador.execute();
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public boolean atualizar(Contato contato) {
		String sql = "UPDATE contato SET nome = ?, email = ?, fone = ? where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, contato.getNome());
			preparador.setString(2, contato.getEmail());
			preparador.setString(3, contato.getFone());
			preparador.setLong(4, contato.getId());
			preparador.execute();
			
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public boolean excluir(Contato contato)	{
		String sql = "DELETE FROM contato where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, contato.getId());
			preparador.execute();
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return resultado;
	}
	
	public List<Contato> listar(Usuario usuario) {
		String sql = "SELECT * FROM contato WHERE usuario_id=? ORDER BY id DESC";

		List<Contato> lista = new ArrayList<Contato>();

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, usuario.getId());

			rs = preparador.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato(usuario);
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				lista.add(contato);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return lista;
	}
	
	public boolean procurarNome(String nome) {
		String sql = "SELECT * FROM contato WHERE nome = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, nome);
			
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
	
	public Long getIdPorNome(String nome) {
		String sql = "SELECT id FROM contato WHERE nome = ?";
		Long id = null;
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, nome);
			
			rs = preparador.executeQuery();
			
			id = rs.getLong("id");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharInstrucao(preparador);
			ConexaoBanco.fecharConexao(conexao);
		}
		return id;
	}
}
