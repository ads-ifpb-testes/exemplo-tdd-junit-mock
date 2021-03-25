package br.edu.ifpb.testes.carrinho;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoCompras {

    private List<Produto> produtos;
    private Estoque estoque;

    public CarrinhoCompras() {
        this.produtos = new LinkedList<Produto>();
        this.estoque = new Estoque();
    }

    public CarrinhoCompras(Estoque estoque) {
        this.produtos = new LinkedList<Produto>();
        this.estoque = estoque;
    }

    public void adicionarItem(Produto produto) throws ForaEstoqueException {
        if (estoque.temNoEstoque(produto))
            this.produtos.add(produto);
        else
            throw new ForaEstoqueException("Produto fora de estoque");
    }

    public int getQuantidade() {
        return this.produtos.size();
    }

    public void removerItem(Produto produto) {
        this.produtos.remove(produto);
    }
}
