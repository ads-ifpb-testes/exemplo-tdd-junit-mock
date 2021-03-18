package br.edu.ifpb.testes.carrinho;

import org.junit.Assert;
import org.junit.Test;

public class CarrinhoDeComprasTest {

    @Test
    public void adicionarItens() {
        // 1. Preparar o cenário
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

        // 2. Realizar o estimulo
        Produto produto = new Produto(1, "Teclado Gamer", 200d);
        carrinhoCompras.adicionarItem(produto);

        // 3. Fazer comparação
        int qtdeCarrinho = carrinhoCompras.getQuantidade();
        Assert.assertEquals("O carrinho de compras não está funcionando adequadamente", 1, qtdeCarrinho);
    }

    @Test
    public void removerItens() {
        // 1. Preparar o cenário
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();

        // 2. Realizar o estimulo
        Produto produto = new Produto(1, "Teclado Gamer", 200d);
        carrinhoCompras.adicionarItem(produto);
        carrinhoCompras.removerItem(produto);

        // 3. Fazer comparação
        int qtdeCarrinho = carrinhoCompras.getQuantidade();
        Assert.assertEquals("O carrinho de compras não está funcionando adequadamente", 0, qtdeCarrinho);
    }

}
