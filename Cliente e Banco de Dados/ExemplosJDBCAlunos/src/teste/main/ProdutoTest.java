package src.teste.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import src.Main.Produto;
import src.Main.dao.ProdutoDAO;
import src.Main.dao.IProdutoDAO;


public class ProdutoTest {

    @Test
    public void incluirTest() throws Exception {
        Produto produto = new Produto();
        IProdutoDAO dao = new ProdutoDAO();

        produto.setId(1);
        produto.setNome("Celular");
        produto.setQuantidade("1");
        int qtd = dao.Incluir(produto);
        assertTrue(qtd == 1);

        Produto Consultar = dao.Consultar(produto.getNome());
        assertNotNull(Consultar);
        assertNotNull(Consultar.getId());
        assertEquals(produto.getQuantidade(), Consultar.getQuantidade());
        assertEquals(produto.getNome(), Consultar.getNome());

        Produto qtdDel = dao.Excluir(Consultar);
	    assertNotNull(qtdDel);

        Produto Atualizar = dao.Atualizar(produto);
        Atualizar.setNome("Televisão");
        assertEquals(produto.getNome(), Atualizar.getNome());
    }
}