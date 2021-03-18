package br.edu.ifpb.testes.carrinho;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoCompras {

    private List<Produto> produtos;

    public CarrinhoCompras() {
        this.produtos = new LinkedList<Produto>();
    }

    public void adicionarItem(Produto produto) {
        this.produtos.add(produto);
    }

    public int getQuantidade() {
        return this.produtos.size();
    }

    public void removerItem(Produto produto) {
        this.produtos.remove(produto);
    }
}
