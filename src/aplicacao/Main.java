package aplicacao;

import model.Moeda;
import service.ConexaoExchangeRateAPI;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Moeda moeda = new Moeda();

        moeda.setNome("kyd");

        ConexaoExchangeRateAPI conexao = new ConexaoExchangeRateAPI(moeda);

        scanner.close();


    }
}