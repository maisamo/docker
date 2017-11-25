package pds.web.smartalerta.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.smartalerta.conexao.ConexaoBanco;
import pds.web.smartalerta.model.Contato;
import pds.web.smartalerta.model.Email;

public class EmailDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado = false;
	
	public boolean inserir(Email email)	{
		String sql = "INSERT INTO email (email,contato_id) values (?,?)";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, email.getEmail());
			preparador.setLong(2, email.getContato().getId());
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
	
	public boolean atualizar(Email email) {
		String sql = "UPDATE email SET email = ? where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, email.getEmail());
			preparador.setLong(2, email.getId());
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
	
	public boolean excluir(Email email)	{
		String sql = "DELETE FROM email where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, email.getId());
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
	
	public List<Email> listar(Contato contato) {
		String sql = "SELECT * FROM email WHERE contato_id=? ORDER BY id DESC";

		List<Email> lista = new ArrayList<Email>();

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, contato.getId());

			rs = preparador.executeQuery();

			while (rs.next()) {
				Email email = new Email(contato);
				email.setId(rs.getLong("id"));
				email.setEmail(rs.getString("email"));
				lista.add(email);
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
