package model;

public class Venda {
    private String produto;
    private int quantidade;

    public Venda(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

