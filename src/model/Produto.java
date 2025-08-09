package model;

public class Produto {

    private String descricao;
    private double preco;
    private String categoria;
    private String codigoDeBarras;
    private String imagem;
    private int fornecedorId;
    private int estoqueId;

    
    public Produto() {}

    // Construtor 
    public Produto(String descricao, double preco, String categoria, String codigoDeBarras, String imagem, int fornecedorId, int estoqueId) {
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.codigoDeBarras = codigoDeBarras;
        this.imagem = imagem;
        this.fornecedorId = fornecedorId;
        this.estoqueId = estoqueId;
    }

   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public int getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(int estoqueId) {
        this.estoqueId = estoqueId;
    }
}

