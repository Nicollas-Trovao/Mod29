package src.Main.dao;

import src.Main.Cliente;

public interface IClientDAO {

    public Integer Cadastrar(Cliente cliente) throws Exception;

    public Cliente Atualizar(Cliente consultar) throws Exception;

    public Cliente Consultar(String codigo)throws Exception;

    public Cliente Excluir(Cliente consultar)throws Exception;
    
}
