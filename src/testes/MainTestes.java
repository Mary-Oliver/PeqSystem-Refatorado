package testes;

import dao.VendaDAO;
import model.Venda;
import service.VendaService;

public class MainTestes {
    public static void main(String[] args) {
        VendaDAO vendaDAO = new VendaDAO();
        VendaService vendaService = new VendaService(vendaDAO);

        // Teste 1: adicionar venda válida
        boolean ok = vendaService.adicionarVenda("Produto Teste", "3");
        System.out.println("Venda válida adicionada? " + ok);

        // Teste 2: adicionar venda inválida
        boolean erro = vendaService.adicionarVenda("", "abc");
        System.out.println("Venda inválida rejeitada? " + !erro);

        // Listar vendas
        System.out.println("Resumo das vendas:");
        System.out.println(vendaService.gerarResumo());
    }
}
