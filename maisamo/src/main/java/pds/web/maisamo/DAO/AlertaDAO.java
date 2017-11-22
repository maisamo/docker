package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.ConexaoBanco;
import pds.web.maisamo.model.Alerta;
import pds.web.maisamo.model.Usuario;

public class AlertaDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado = false;

	public boolean inserir(Alerta alerta) {
		String sql = "INSERT INTO alerta (titulo,mensagem,categoria,usuario_id) values (?,?,?,?)";

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, alerta.getTitulo());
			preparador.setString(2, alerta.getMensagem());
			preparador.setString(3, alerta.getCategoria());
			preparador.setLong(4, alerta.getUsuario().getId());
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
	
	public boolean atualizar(Alerta alerta) {
		String sql = "UPDATE alerta SET titulo = ?, mensagem = ?, categoria = ? where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, alerta.getTitulo());
			preparador.setString(2, alerta.getMensagem());
			preparador.setString(3, alerta.getCategoria());
			preparador.setLong(4, alerta.getId());
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

	public boolean excluir(Alerta alerta) {
		String sql = "DELETE FROM alerta where id = ?";

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, alerta.getId());
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

	public List<Alerta> listar(Usuario usuario) {
		String sql = "SELECT * FROM alerta WHERE usuario_id=? order by id desc";

		List<Alerta> lista = new ArrayList<Alerta>();

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, usuario.getId());

			rs = preparador.executeQuery();

			while (rs.next()) {
				Alerta alerta = new Alerta(usuario);
				alerta.setId(rs.getLong("id"));
				alerta.setTitulo(rs.getString("titulo"));
				alerta.setMensagem(rs.getString("mensagem"));
				alerta.setCategoria(rs.getString("categoria"));
				lista.add(alerta);
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
	
	public List<Alerta> listarCategoria(String categoria) {
		String sql = "SELECT * FROM alerta WHERE categoria = ?";
		
		List<Alerta> lista = new ArrayList<Alerta>();
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, categoria);
			
			rs = preparador.executeQuery();

			while (rs.next()) {
				Alerta alerta = new Alerta();
				alerta.setId(rs.getLong("id"));
				alerta.setTitulo(rs.getString("titulo"));
				alerta.setMensagem(rs.getString("mensagem"));
				alerta.setCategoria(rs.getString("categoria"));
				lista.add(alerta);
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
	
	public boolean procurarTitulo(String titulo) {
		String sql = "SELECT * FROM alerta WHERE titulo = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, titulo);
			
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
}