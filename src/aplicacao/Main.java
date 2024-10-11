package aplicacao;
import mensagens.Mensagem;
import models.Moeda;
import service.ConexaoExchangeRateAPI;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ConexaoExchangeRateAPI conexao = new ConexaoExchangeRateAPI();
        Mensagem mensagem = new Mensagem();

        String opcao = "";
        double valor = 0.0;

        while (!opcao.equals("0")) {
            mensagem.apresentacao();
            opcao = sc.next();

            if (opcao.equals("1")) {
                System.out.print("Digite moeda para cotação: ");
                String moedaParaConsulta = sc.next();
                conexao.testaMoeda(moedaParaConsulta);

                Moeda moeda = new Moeda();
                moeda.setNome(moedaParaConsulta);
                conexao.pegarCotacao(moeda);
            }

            if (opcao.equals("2")) {
                System.out.print("Digite a Primeira moeda: ");
                String nomePrimeiraMoeda = sc.next();
                conexao.testaMoeda(nomePrimeiraMoeda);

                System.out.print("Digite a Segunda moeda: ");
                String nomeSegundaMoeda = sc.next();
                conexao.testaMoeda(nomeSegundaMoeda);

                Moeda moeda1 = new Moeda();
                Moeda moeda2 = new Moeda();
                moeda1.setNome(nomePrimeiraMoeda);
                moeda2.setNome(nomeSegundaMoeda);

                // -------------------- FAZER UM MÉTODO PARA VALIDAR SEM POLUIR AQUI -------------------------
                System.out.print("Digite Valor para conversão: ");
                try {
                    valor = sc.nextDouble();
                    if (valor < 0) {
                        System.out.println("Valor deve ser Maior que Zero");
                        continue;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Caracter Inválido! \n Apenas valores numéricos!");
                    continue;
                }
                conexao.conversaoDeMoedas(moeda1, moeda2, valor);

            }

            if (opcao.equals("3")) {
                System.out.print("Digite a Primeira moeda: ");
                String nomePrimeiraMoeda = sc.next();
                conexao.testaMoeda(nomePrimeiraMoeda);

                System.out.print("Digite a Segunda moeda: ");
                String nomeSegundaMoeda = sc.next();
                conexao.testaMoeda(nomeSegundaMoeda);

                Moeda moeda1 = new Moeda();
                Moeda moeda2 = new Moeda();
                moeda1.setNome(nomePrimeiraMoeda);
                moeda2.setNome(nomeSegundaMoeda);
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