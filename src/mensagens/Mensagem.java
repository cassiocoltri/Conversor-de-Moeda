package mensagens;

public class Mensagem {

    public void apresentacao() {
        System.out.println("\n**********************************************************");
        System.out.println("Bem vindo ao conversor de Moedas, digite a opção desejada: ");
        System.out.println("[1] Para Consulta uma moeda existente (COD 3 digitos | Ex: BRL).");
//        System.out.println("[2] Para Cotação de valores referente a duas moedas.");
//        System.out.println("[3] Para comparar duas moedas.");
        System.out.println("[2] Dólar (USD) =>> Peso argentino (ARS)");
        System.out.println("[3] Peso argentino (ARS) =>> Dolar (USD)");
        System.out.println("[4] Dólar (USD) =>> Real brasileiro (BRL)");
        System.out.println("[5] Real brasileiro (BRL) =>> Dólar (USD)");
        System.out.println("[6] Dólar (USD) =>> Peso colombiano (COP)");
        System.out.println("[7] Peso colombiano (COP) =>> Dólar (USD)");
        System.out.println("[0] Para SAIR");
        System.out.println("**********************************************************");
        System.out.print("Opção: ");
    }

    public void valorDemoeda() {
        System.out.print("Digite o valor para conversão: ");
    }

}
