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
        String valor;

        while (!opcao.equals("0")) {
            mensagem.apresentacao();
            opcao = sc.next();

                if (opcao.equals("1")) {
                    System.out.print("Digite moeda para cotação: ");
                    String moedaParaConsulta = sc.next();

                    if (!conexao.testaMoeda(moedaParaConsulta)) {
                        break;
                    } else {
                        Moeda moeda = new Moeda();
                        moeda.setNome(moedaParaConsulta);
                        conexao.pegarCotacao(moeda);
                    }

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

                    System.out.print("Digite Valor para conversão: ");
                    valor = sc.next();
                    if (conexao.testaValor(valor)) continue;
                    conexao.conversaoDeMoedas(moeda1, moeda2, Double.parseDouble(valor));

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

                // Priorizar a PARTE DE BAIXO (4 a 9 !!!! [ARRUMADO!!!!]
                if (opcao.equals("4")) {
                    mensagem.valorDemoeda();
                    valor = sc.next();
                    if (!conexao.testaValor((valor))) continue;
                    conexao.dolarParaPesoArgentino(Double.parseDouble(valor));
                }
                if (opcao.equals("5")) {
                    mensagem.valorDemoeda();
                    valor = sc.next();
                    if (!conexao.testaValor(valor)) continue;
                    conexao.pesoArgentinoParaDolar(Double.parseDouble(valor));

                }
                if (opcao.equals("6")) {
                    mensagem.valorDemoeda();
                    valor = sc.next();
                    if (!conexao.testaValor((valor))) continue;
                    conexao.dolarParaRealBrasileiro(Double.parseDouble(valor));
                }
                if (opcao.equals("7")) {
                    mensagem.valorDemoeda();
                    valor = sc.next();
                    if (!conexao.testaValor((valor))) continue;
                    conexao.drealBrasileiroParaDolar(Double.parseDouble(valor));
                }
                if (opcao.equals("8")) {
                    mensagem.valorDemoeda();
                    valor = sc.next();
                    if (!conexao.testaValor((valor))) continue;
                    conexao.dolarParaPesoColombiano(Double.parseDouble(valor));
                }
                if (opcao.equals("9")) {
                    mensagem.valorDemoeda();
                    valor = sc.next();
                    if (!conexao.testaValor(valor)) continue;
                    conexao.pesoColombianoParaDolar(Double.parseDouble(valor));
                }


        }

        System.out.println("Programa Finalizado!");

        sc.close();

    }
}