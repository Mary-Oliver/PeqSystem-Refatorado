package service;

import dao.VendaDAO;
import model.Venda;

public class VendaService {
    private VendaDAO vendaDAO;

    public VendaService(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    // Método principal para adicionar venda
    public boolean adicionarVenda(String produto, String quantidadeTexto) {
        if (produto.isEmpty() || quantidadeTexto.isEmpty()) {
            return false; // campos vazios
        }
        try {
            int quantidade = validarQuantidade(quantidadeTexto);
            vendaDAO.adicionarVenda(new Venda(produto, quantidade));
            return true;
        } catch (NumberFormatException e) {
            return false; // quantidade inválida
        }
    }

    // 🔹 Novo método: separação da lógica de validação
    protected int validarQuantidade(String quantidadeTexto) throws NumberFormatException {
        return Integer.parseInt(quantidadeTexto);
    }

    // Gera resumo das vendas
    public String gerarResumo() {
        StringBuilder resumo = new StringBuilder();
        for (Venda venda : vendaDAO.listarVendas()) {
            resumo.append(venda.getProduto())
                  .append(" - ")
                  .append(venda.getQuantidade())
                  .append(" unidades\n");
        }
        return resumo.toString();
    }
}
