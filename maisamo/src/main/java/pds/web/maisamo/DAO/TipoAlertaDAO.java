package pds.web.maisamo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.maisamo.conexao.Conexao;

public class TipoAlertaDAO {
	private Connection connection;
	private Conexao conexao;
	
	/*public TipoAlertaDAO() {
		conexao = new Conexao();
	}
	
	PreparedStatement preparador;
	public List<TipoAlerta> listar()
	{
		String sql = "SELECT * FROM tipo_alerta order by id desc";
		
		List<TipoAlerta> lista = new ArrayList<TipoAlerta>();
		
		
		try {
			
			connection = conexao.abrirConexao();
			preparador = connection.prepareStatement(sql);
			
			ResultSet rs = preparador.executeQuery();
			
			while(rs.next())
			{
				TipoAlerta tipo_alerta = new TipoAlerta();
				tipo_alerta.setId(rs.getLong("id"));
				tipo_alerta.setNome(rs.getString("nome"));
				tipo_alerta.setDescricao(rs.getString("descricao"));
				lista.add(tipo_alerta);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			Conexao.fecharInstrucao(preparador);
			Conexao.fecharConexao(connection);
		}
		
		return lista;
	}*/
}
