package aplicacao;
import mensagens.Mensagem;
import models.Moeda;
import service.ConexaoExchangeRateAPI;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ConexaoExchangeRateAPI conexao = new ConexaoExchangeRateAPI();
        Mensagem mensagem = new Mensagem();

        String opcao = "";

        while (!opcao.equals("7")) {
            mensagem.apresentacao();
            opcao = sc.next();

            if (opcao.equals("1")) {
                Moeda moeda = new Moeda();
                System.out.print("Digite moeda para cotação: ");
                String moedaParaConsulta = sc.next();
                moeda.setNome(moedaParaConsulta);
                conexao.pegarCotacao(moeda);

            } else if (opcao.equals("2")) {
                Moeda moeda1 = new Moeda();
                Moeda moeda2 = new Moeda();

                double valor;
                System.out.print("Digite a Primeira moeda: ");
                moeda1.setNome(sc.next());
                System.out.print("Digite a Segunda moeda: ");
                moeda2.setNome(sc.next());
                System.out.print("Digite Valor para conversão: ");
                valor = sc.nextDouble();
                conexao.conversaoDeMoedas(moeda1, moeda2, valor);

            } else if (opcao.equals("3")) {
                Moeda moeda1 = new Moeda();
                Moeda moeda2 = new Moeda();

                System.out.print("Digite a Primeira moeda: ");
                moeda1.setNome(sc.next());
                System.out.print("Digite a Segunda moeda: ");
                moeda2.setNome(sc.next());
                conexao.conversaoDeMoedas(moeda1, moeda2);
            } else {
                System.out.println("Obrigado por isar nossos serviços!");
            }
        }

        System.out.println("Programa Finalizado!");

        sc.close();

    }
}