package aplicacao;
import exceptions.MoedaNaoEncontradaException;
import model.Moeda;
import service.ConexaoExchangeRateAPI;
import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Moeda moeda = new Moeda();

        System.out.print("Digite moeda para cotação: ");
        String moedaParaConsulta = sc.next();

        moeda.setNome(moedaParaConsulta);

//        JOptionPane.showMessageDialog(null, "Teste",
//                "Conversor de Moeda", JOptionPane.INFORMATION_MESSAGE);
//        Moeda moeda = new Moeda(JOptionPane.showInputDialog("Digite uma Moeda para Cotação"));

        ConexaoExchangeRateAPI conexao = new ConexaoExchangeRateAPI();
        conexao.pegarCotacao(moeda);

        sc.close();

    }
}