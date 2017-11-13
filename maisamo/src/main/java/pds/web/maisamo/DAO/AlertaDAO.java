package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.Conexao;
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
		String sql = "INSERT INTO alerta (titulo,mensagem ,categoria ) values (?,?,?)";
		
		try {
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			preparador.setString(1, alerta.getTitulo());
			preparador.setString(2, alerta.getMensagem());
			preparador.setString(3, alerta.getCategoria());
			
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
		String sql = "UPDATE alerta SET titulo = ?, mensagem = ?, categoria = ?, tipoalerta = ? where id = ?";
		
		try {
			
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			preparador.setString(1, alerta.getTitulo());
			preparador.setString(2, alerta.getMensagem());
			preparador.setString(3, alerta.getCategoria());
			preparador.setLong(4, alerta.getId());
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
				alerta.setTitulo(rs.getString("titulo"));
				alerta.setMensagem(rs.getString("mensagem"));
				alerta.setCategoria(rs.getString("categoria"));
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