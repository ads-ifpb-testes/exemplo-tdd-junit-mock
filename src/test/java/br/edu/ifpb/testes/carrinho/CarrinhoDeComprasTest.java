package br.edu.ifpb.testes.carrinho;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CarrinhoDeComprasTest {

    @Mock
    private Estoque estoque;
    private CarrinhoCompras carrinhoCompras;

    @Before
    public void setUp() {
        // 1. Preparar o cenário
        MockitoAnnotations.initMocks(this);
        this.carrinhoCompras = new CarrinhoCompras(this.estoque);
    }

    @Test
    public void adicionarItens() throws ForaEstoqueException {
        when(estoque.temNoEstoque(any(Produto.class))).thenReturn(true);

        // 2. Realizar o estimulo
        Produto produto = new Produto(1, "Teclado Gamer", 200d);
        carrinhoCompras.adicionarItem(produto);

        // 3. Fazer comparação
        int qtdeCarrinho = carrinhoCompras.getQuantidade();
        Assert.assertEquals("O carrinho de compras não está funcionando adequadamente", 1, qtdeCarrinho);
    }

    @Test
    public void removerItens() throws ForaEstoqueException {
        when(estoque.temNoEstoque(any(Produto.class))).thenReturn(false);

        Produto produto = new Produto(1, "Teclado Gamer", 200d);
        when(estoque.temNoEstoque(produto)).thenReturn(true);

        // 2. Realizar o estimulo
        carrinhoCompras.adicionarItem(produto);
        carrinhoCompras.removerItem(produto);

        // 3. Fazer comparação
        int qtdeCarrinho = carrinhoCompras.getQuantidade();
        Assert.assertEquals("O carrinho de compras não está funcionando adequadamente", 0, qtdeCarrinho);
    }

    @Test(expected = ForaEstoqueException.class)
    public void adicionarItemForaEstoque() throws ForaEstoqueException {
        // Preparar as respostas do Mock
        when( // Quando
                estoque.temNoEstoque( // o método 'temNoEstoque(produto)' for invocado
                        any(Produto.class) // Passando qualquer objeto do tipo Produto
                )
        ).thenReturn(false); // Então retorne falso

        // 2. Realizar o estimulo
        Produto produto = new Produto(15, "Monitor", 2000d);
        carrinhoCompras.adicionarItem(produto);
    }

}
