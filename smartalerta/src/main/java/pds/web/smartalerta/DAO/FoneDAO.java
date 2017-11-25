package pds.web.smartalerta.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pds.web.smartalerta.conexao.ConexaoBanco;
import pds.web.smartalerta.model.Contato;
import pds.web.smartalerta.model.Fone;

public class FoneDAO {
	private Connection conexao;
	private ResultSet rs;
	private PreparedStatement preparador;
	private boolean resultado = false;
	
	public boolean inserir(Fone fone)	{
		String sql = "INSERT INTO fone (fone,contato_id) values (?,?)";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, fone.getFone());
			preparador.setLong(2, fone.getContato().getId());
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
	
	public boolean atualizar(Fone fone) {
		String sql = "UPDATE fone SET fone = ? where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setString(1, fone.getFone());
			preparador.setLong(2, fone.getId());
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
	
	public boolean excluir(Fone fone)	{
		String sql = "DELETE FROM fone where id = ?";
		
		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, fone.getId());
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
	
	public List<Fone> listar(Contato contato) {
		String sql = "SELECT * FROM fone WHERE contato_id=? ORDER BY id DESC";

		List<Fone> lista = new ArrayList<Fone>();

		try {
			conexao = ConexaoBanco.abrirConexao();
			preparador = conexao.prepareStatement(sql);
			preparador.setLong(1, contato.getId());

			rs = preparador.executeQuery();

			while (rs.next()) {
				Fone fone = new Fone(contato);
				fone.setId(rs.getLong("id"));
				fone.setFone(rs.getString("fone"));
				lista.add(fone);
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
