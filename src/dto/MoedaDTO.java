package dto;

import java.util.Objects;

public record MoedaDTO(String base_code, String target_code, String conversion_rate, String conversion_result) {

    public String opcaoDois() {
        return "Primeira Moeda: " + base_code
                + "\nSegunda Moeda: " + target_code
                + "\nValor Informado: " + conversion_rate
                + "\nTotal: " + conversion_result
                +"\n*************Segunda Menságem!*****************";
    }

    public String opcaoTres() {
        return "Primeira Moeda: " + base_code
                + "\nSegunda Moeda: " + target_code
                + "\nValor Informado: " + conversion_rate
                + "\n*************Terceira Menságem!*****************";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoedaDTO moedaDTO = (MoedaDTO) o;
        return Objects.equals(conversion_result, moedaDTO.conversion_result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conversion_result);
    }

    @Override
    public String conversion_result() {
        return conversion_result;
    }
}
