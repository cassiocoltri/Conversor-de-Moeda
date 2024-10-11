package dto;

public record MoedaDTO(String base_code, String target_code, String conversion_rate, String conversion_result) {


    public String opcaoPadrao() { // Menságem recebido nas consultas padronizadas
        return "-----------------------------------\n" +
                "Moeda Principal: " + base_code
                + "\nMoeda a ser convertida: " + target_code
                + "\nTaxa de câmbio 1:1: " + conversion_rate
                + "\nTotal Convertido: " + conversion_result
                + "\n----------------------------------";
    }

    public String opcaoComparacaoDuasMoedas() {
        return "-----------------------------------\n"
                + "Primeira Moeda: " + base_code
                + "\nSegunda Moeda: " + target_code
                + "\nTaxa de câmbio 1:1: " + conversion_rate
                + "\n----------------------------------";
    }

    @Override
    public String conversion_result() {
        return conversion_result;
    }

    @Override
    public String base_code() {
        return base_code;
    }
}
