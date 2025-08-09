package dao;

import model.Venda;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private List<Venda> vendas = new ArrayList<>();

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> listarVendas() {
        return vendas;
    }
}
