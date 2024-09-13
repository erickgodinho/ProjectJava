package Desafio;

import javax.swing.*;
import java.util.ArrayList;

public class SuperMarket {
    static ArrayList<Produto> produtos = new ArrayList<>();
    public static void main(String[] args) {

        boolean continuar = true;

        while(continuar) {

            String menu = "Escolha uma opção:\n" +
                    "1. Adicionar produtos\n" +
                    "2. Listar produtos\n" +
                    " 3. Remover produto\n" +
                    "4. Calcular total em estoque\n" +
                    "5. Sair";

            int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao){

                case 1:
                    adicionarProduto();
                    break;

                case 2:
                    listarProdutos();
                    break;

                case 3:
                    removerProduto();
                    break;

                case 4:
                    calcularTotalEstoque();
                    break;

                case 5:
                    continuar = false;
                    JOptionPane.showMessageDialog(null,"Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida");


            }

        }

    }

    public static void adicionarProduto(){

        String nome = JOptionPane.showInputDialog("Digite o nome do produto");
        int quantidade = lerQuantidade();
        double preco = lerPreco();

        Produto produto = new Produto(nome, quantidade, preco);
        produtos.add(produto);

        JOptionPane.showMessageDialog(null, "Produto " + nome + " adicionado com sucesso!" );
    }

    public static int lerQuantidade(){
        int quantidade = 0;
        boolean entradaValida = false;

        while (!entradaValida){

            try {

                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto desejada"));

                if (quantidade < 0 ) throw new Exception("A quantidade não pode ser negativo");
                entradaValida = true;
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"Entrada inválida" + e.getMessage());
            }
        }

        return quantidade;
    }

    public static double lerPreco(){
        double preco = 0;
        boolean entradaValida = false;

        while (!entradaValida) {

            try {

                preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto"));

                if (preco < 0) throw new Exception("O preço não pode ser negativo");
                entradaValida = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida" + e.getMessage());
            }
        }
        return preco;

    }

        public static void listarProdutos() {
            if (produtos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
                return;
            }

            StringBuilder lista = new StringBuilder();

            for (Produto produto : produtos) {
                lista.append(produto).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }

        public static void removerProduto(){
            String nome = JOptionPane.showInputDialog("Digite o produto a ser removido");
            Produto produtoRemover = null;

                    for ( Produto produto : produtos){
                        if (produto.getNome().equalsIgnoreCase(nome)){
                            produtoRemover = produto;
                            break;
                        }
                    }

                    if (produtoRemover != null){
                        produtos.remove(produtoRemover);
                        JOptionPane.showMessageDialog(null,"Produto " + nome + " removido com sucesso");
                    } else{
                        JOptionPane.showMessageDialog(null, " Produto" + nome + " não encontrado");
                    }

        }

        public static void calcularTotalEstoque(){
            double totalEstoque = 0;

                    for(Produto produto : produtos){
                        totalEstoque += produto.getValorEstoque();
                    }
                    JOptionPane.showMessageDialog(null,"Valor total em estoque: R$" + String.format("%.2f", totalEstoque));
        }

        public static void atualizarProduto(){
            String nome = JOptionPane.showInputDialog("Digite o nome do produto para ser atualizado");

            for (Produto produto : produtos){
                if (produto.getNome().equalsIgnoreCase(nome)){
                    produto.setQuantidade(lerQuantidade());
                    produto.setPreco(lerPreco());
                    JOptionPane.showMessageDialog(null,"Produto atualizado");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null,"Produto não encontrado");
        }



}

