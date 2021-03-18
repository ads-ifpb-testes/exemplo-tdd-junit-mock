package br.edu.ifpb.testes.carrinho;

public class Produto {

    private int id;
    private String nomeProduto;
    private double valorEmDolar;

    public Produto(int id, String nomeProduto, double valorEmDolar) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valorEmDolar = valorEmDolar;
    }
}
