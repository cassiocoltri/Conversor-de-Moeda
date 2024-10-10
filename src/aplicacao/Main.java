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
        double valor;

        while (!opcao.equals("0")) {
            mensagem.apresentacao();
            opcao = sc.next();

            if (opcao.equals("1")) {
                Moeda moeda = new Moeda();
                System.out.print("Digite moeda para cotação: ");
                String moedaParaConsulta = sc.next();
                moeda.setNome(moedaParaConsulta);
                conexao.pegarCotacao(moeda);
            }
            if (opcao.equals("2")) {
                Moeda moeda1 = new Moeda();
                Moeda moeda2 = new Moeda();
                System.out.print("Digite a Primeira moeda: ");
                moeda1.setNome(sc.next());
                System.out.print("Digite a Segunda moeda: ");
                moeda2.setNome(sc.next());
                System.out.print("Digite Valor para conversão: ");
                valor = sc.nextDouble();
                conexao.conversaoDeMoedas(moeda1, moeda2, valor);

            }
            if (opcao.equals("3")) {
                Moeda moeda1 = new Moeda();
                Moeda moeda2 = new Moeda();

                System.out.print("Digite a Primeira moeda: ");
                moeda1.setNome(sc.next());
                System.out.print("Digite a Segunda moeda: ");
                moeda2.setNome(sc.next());
                conexao.conversaoDeMoedas(moeda1, moeda2);

            }
            if (opcao.equals("4")) {
                mensagem.valorDemoeda();
                valor = sc.nextDouble();
                conexao.dolarParaPesoArgentino(valor);

            }
            if (opcao.equals("5")) {
                mensagem.valorDemoeda();
                valor = sc.nextDouble();
                conexao.pesoArgentinoParaDolar(valor);
            }
            if (opcao.equals("6")) {
                mensagem.valorDemoeda();
                valor = sc.nextDouble();
                conexao.dolarParaRealBrasileiro(valor);
            }
            if (opcao.equals("7")) {
                mensagem.valorDemoeda();
                valor = sc.nextDouble();
                conexao.drealBrasileiroParaDolar(valor);
            }
            if (opcao.equals("8")) {
                mensagem.valorDemoeda();
                valor = sc.nextDouble();
                conexao.dolarParaPesoColombiano(valor);
            }
            if (opcao.equals("9")) {
                mensagem.valorDemoeda();
                valor = sc.nextDouble();
                conexao.pesoColombianoParaDolar(valor);
            }
        }

        System.out.println("Programa Finalizado!");

        sc.close();

    }
}