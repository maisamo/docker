package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.ConexaoBanco;
import pds.web.maisamo.model.EnvioAlertaContato;
import pds.web.maisamo.model.EnvioAlerta;
import pds.web.maisamo.model.Contato;

public class EnvioAlertaContatoDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado = false;
	
	public boolean inserir(EnvioAlertaContato envio_alerta_contato) {
		String sql = "INSERT INTO envio_alerta_contato (envio_alerta_id,contato_id) values (?,?)";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, envio_alerta_contato.getEnvioAlerta().getId());
			preparador.setLong(2, envio_alerta_contato.getContato().getId());
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
	
	public boolean excluir(EnvioAlertaContato envio_alerta_contato) {
		String sql = "DELETE FROM envio_alerta_contato WHERE id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, envio_alerta_contato.getId());
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
	
	public List<EnvioAlertaContato> listar(EnvioAlerta envio_alerta) {
		/*
		String sql = "SELECT c.* FROM envio_alerta_contato eac "
					+ "JOIN (SELECT ea.* FROM envio_alerta ea"
					+ "		JOIN (SELECT * FROM alerta WHERE usuario_id = ?) au "
					+ "		ON au.id = ea.alerta_id) eaau"
					+ "ON eaau.id = eac.alerta_id JOIN contato c ON c.id = eac.contato_id"
					+ "ORDER BY eac.id desc";
		*/
		String sql = "SELECT * FROM envio_alerta_contato eac "
					+ "JOIN contato c ON c.id = eac.contato_id "
					+ "WHERE envio_alerta_id = ? "
					+ "ORDER BY eac.id desc";

		List<EnvioAlertaContato> lista = new ArrayList<EnvioAlertaContato>();

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, envio_alerta.getId());
			
			rs = preparador.executeQuery();
			
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				EnvioAlertaContato envio_alerta_contato = new EnvioAlertaContato(contato, envio_alerta);
				lista.add(envio_alerta_contato);
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
}
