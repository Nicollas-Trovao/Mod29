package src.Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.Main.Cliente;

public class ClientDAO implements IClientDAO {

    @Override
    public Integer Cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO venda_online (Id, Codigo, Nome) VALUES (nextval('SQ_CLIENTE'), ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(2, cliente.getCodigo());
            stm.setString(1, cliente.getNome());
            return stm.executeUpdate();
        } catch(Exception e){
            throw e;

        } finally {
            if (stm != null && !stm.isClosed()){
                stm.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
        }
    }
}

    @Override
    public Cliente Consultar(String codigo) throws Exception {
    Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from venda_online where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
    }

    @Override
    public Cliente Excluir(Cliente cliente) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;

        try {
	    connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM venda_online WHERE codigo = ?";
        stm = connection.prepareStatement(sql);
        stm.setString(1, cliente.getCodigo());
        stm.executeUpdate();
        return cliente;

		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
    }

	@Override
	public Cliente Atualizar(Cliente cliente) throws Exception {
		Connection connection = null;
        PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String novoNome = cliente.getNome();
			String sql = "UPDATE venda_online SET NOME = ? WHERE codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, novoNome);
			stm.setString(2, cliente.getCodigo());
			stm.executeUpdate();
			return cliente;

		} catch (Exception e){
            throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}

	}

}
