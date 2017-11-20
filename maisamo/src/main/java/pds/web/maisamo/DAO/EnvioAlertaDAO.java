package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.ConexaoBanco;
import pds.web.maisamo.model.EnvioAlerta;
import pds.web.maisamo.model.Alerta;
import pds.web.maisamo.model.Usuario;

public class EnvioAlertaDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado = false;
	
	public boolean inserir(EnvioAlerta envio_alerta) {
		String sql = "INSERT INTO envio_alerta (data_envio,hora_envio,alerta_id) values (?,?,?)";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setDate(1, Date.valueOf(envio_alerta.getDataEnvio()));
			preparador.setTime(2, Time.valueOf(envio_alerta.getHoraEnvio()));
			preparador.setLong(3, envio_alerta.getAlerta().getId());
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
	
	public boolean excluir(EnvioAlerta envio_alerta) {
		String sql = "DELETE FROM envio_alerta where id=?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, envio_alerta.getId());
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

	public List<EnvioAlerta> listar(Usuario usuario) {
		String sql = "SELECT * FROM envio_alerta ea "
					+ "JOIN (SELECT * FROM alerta WHERE usuario_id = ?) au "
					+ "ON au.id = ea.alerta_id "
					+ "ORDER BY ea.id desc";

		List<EnvioAlerta> lista = new ArrayList<EnvioAlerta>();

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, usuario.getId());
			
			rs = preparador.executeQuery();
			
			while(rs.next()) {
				Alerta alerta = new Alerta(usuario);
				alerta.setTitulo(rs.getString("titulo"));
				alerta.setCategoria(rs.getString("categoria"));
				EnvioAlerta envio_alerta = new EnvioAlerta(alerta);
				envio_alerta.setDataHoraEnvio(
						LocalDateTime.of(
								rs.getDate("data_envio").toLocalDate(), 
								rs.getTime("hora_envio").toLocalTime()
								)
						);
				lista.add(envio_alerta);
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
