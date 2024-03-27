package src.Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.Main.Produto;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public int Incluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO produtos (id, nome, quantidade) VALUES (nextval('seq_produto'), ?, ?)";
        stm = connection.prepareStatement(sql);
        stm.setString(2, produto.getQuantidade());
        stm.setString(1, produto.getNome());
    
        return (int) stm.executeUpdate();
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
    public Produto Atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			String novoNome = produto.getNome();
			String sql = "UPDATE produtos SET NOME = ? WHERE id = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, novoNome);
			stm.setLong(2,  produto.getId());
			stm.executeUpdate();
			return produto;

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

    @Override
public Produto Consultar(String nome) throws Exception {
    Connection connection = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Produto produto = null;

    try {
        connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM produtos WHERE nome = ?";
        stm = connection.prepareStatement(sql);
        stm.setString(1, nome);
        rs = stm.executeQuery();
        if (rs.next()) {
            produto = new Produto();
            produto.setId((int) rs.getLong("id"));
            produto.setQuantidade(rs.getString("quantidade"));
            produto.setNome(rs.getString("nome"));
        }
        return produto;
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
    public Produto Excluir(Produto produto) throws Exception {
        Connection connection = null;
		PreparedStatement stm = null;

        try {
	    connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM produtos WHERE Id = ?";
        stm = connection.prepareStatement(sql);
        stm.setLong(1, produto.getId());
        stm.executeUpdate();
        return produto;

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
}
