package src.teste.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import src.Main.dao.ClientDAO;
import src.Main.dao.IClientDAO;

import org.junit.Test;

import src.Main.Cliente;

public class ClientTest {

    @Test
    public void cadastrarTest() throws Exception {
    Cliente cliente = new Cliente();
    IClientDAO dao = new ClientDAO();

    cliente.setCodigo("01");
    cliente.setNome("Nicollas");
    Integer qtd = dao.Cadastrar(cliente);
    assertTrue(qtd == 1);

    Cliente Consultar = dao.Consultar(cliente.getCodigo());
    assertNotNull(Consultar);
    assertNotNull(Consultar.getId());
    assertEquals(cliente.getCodigo(), Consultar.getCodigo());
    assertEquals(cliente.getNome(), Consultar.getNome());

    // Cliente qtdDel = dao.Excluir(Consultar);
	// assertNotNull(qtdDel);

    Cliente Atualizar = dao.Atualizar(cliente);
    Atualizar.setNome("Nicollas Trovão");
    assertEquals(cliente.getNome(), Atualizar.getNome());
    }
}
