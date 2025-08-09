package service;

import dao.VendaDAO;
import model.Venda;

public class VendaService {
    private VendaDAO vendaDAO;

    public VendaService(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    public boolean adicionarVenda(String produto, String quantidadeTexto) {
        if (produto.isEmpty() || quantidadeTexto.isEmpty()) {
            return false; // campos vazios
        }
        try {
            int quantidade = Integer.parseInt(quantidadeTexto);
            vendaDAO.adicionarVenda(new Venda(produto, quantidade));
            return true;
        } catch (NumberFormatException e) {
            return false; // quantidade inválida
        }
    }

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
