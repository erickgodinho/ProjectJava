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
                    removerProdutos();
                    break;

                case 4:
                    calcularTotalEstoque;
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

    public static void adicionarProduto();

}

