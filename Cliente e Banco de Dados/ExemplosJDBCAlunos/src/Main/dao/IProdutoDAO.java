package src.Main.dao;

import src.Main.Produto;

public interface IProdutoDAO {

    public int Incluir(Produto produto) throws Exception;

    public Produto Atualizar(Produto consultar) throws Exception;

    public Produto Consultar(String nome)throws Exception;

    public Produto Excluir(Produto consultar)throws Exception;

}
