package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.we.maisamo.conexao.Conexao;
import pds.web.maisamo.model.Alerta;

public class AlertaDAO {
	private Connection connection;
	private Conexao conexao;
	
	public AlertaDAO() {
		conexao = new Conexao();
	}
	
	PreparedStatement preparador;
	
	public void cadastrar(Alerta alerta)
	{
		String sql = "INSERT INTO alerta (email,telefone,log_date, tipo_alerta_id, frequencia) values (?,?,?,?,?)";
		
		try {
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			preparador.setString(1, alerta.getEmail());
			preparador.setString(2, alerta.getTelefone());
			preparador.setDate(3, Date.valueOf(alerta.getLog_date()));
			preparador.setLong(4, alerta.getTipoalerta());
			preparador.setInt(5, alerta.getFrequencia());
			
			preparador.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Conexao.fecharInstrucao(preparador);
			Conexao.fecharConexao(connection);
		}
	}
	
	public void editar( Alerta alerta)
	{
		String sql = "UPDATE alerta SET email = ?, telefone = ?, frequencia = ?, tipoalerta = ? where id = ?";
		
		try {
			
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			preparador.setString(1, alerta.getEmail());
			preparador.setString(2, alerta.getTelefone());
			preparador.setInt(3, alerta.getFrequencia());
			preparador.setLong(4, alerta.getTipoalerta());
			preparador.setLong(5, alerta.getId());
			preparador.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			Conexao.fecharInstrucao(preparador);
			Conexao.fecharConexao(connection);
		}
	}
	
	public void excluir(Alerta alerta)
	{
		String sql = "DELETE FROM alerta where id = ?";
		
		try {
			
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			preparador.setObject(1, alerta.getId());
			preparador.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			Conexao.fecharInstrucao(preparador);
			Conexao.fecharConexao(connection);
		}
	}
	
	public List<Alerta> listar()
	{
		String sql = "SELECT * FROM alerta order by id desc";
		
		List<Alerta> lista = new ArrayList<Alerta>();
		
		
		try {
			
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			
			ResultSet rs = preparador.executeQuery();
			
			while(rs.next())
			{
				Alerta alerta = new Alerta();
				alerta.setId(rs.getLong("id"));
				alerta.setEmail(rs.getString("email"));
				alerta.setTelefone(rs.getString("telefone"));
				alerta.setFrequencia(rs.getInt("frequencia"));
				alerta.setTipoalerta(rs.getLong("tipoalerta"));
				lista.add(alerta);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			Conexao.fecharInstrucao(preparador);
			Conexao.fecharConexao(connection);
		}
		
		return lista;
	}

}