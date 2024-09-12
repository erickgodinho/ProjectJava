package Desafio;

public class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public double getValorEstoque(){
        return quantidade * preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preço=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}