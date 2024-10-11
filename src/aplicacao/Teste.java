package aplicacao;



import java.io.IOException;


public class Teste {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Teste!");
        String moeda = "a";

        double teste;

        try {
            teste = Double.parseDouble(moeda);
        } catch (NumberFormatException e) {
            System.out.println("Precisa ser um número!");
        }

    }


//public static void validaMoeda(String nome) {
//    String endero = "https://v6.exchangerate-api.com/v6/2142276e6e85e4b9de64d30f/latest/" + nome;
//
//        try {
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(endero))
//                    .build();
//
//            HttpResponse<String> response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//
//            String json = response.body();
//
//            if (json.contains("{\"result\":\"error\"")) {
//                throw new MoedaNaoEncontradaException();
//            } else {
//                System.out.println(json);
//            }
//        } catch (MoedaNaoEncontradaException | IOException | InterruptedException e) {
//            System.out.println(e.getMessage());
//
//        }
//    }
}