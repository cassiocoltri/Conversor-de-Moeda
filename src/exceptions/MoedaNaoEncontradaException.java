package exceptions;

public class MoedaNaoEncontradaException extends RuntimeException {


    @Override
    public String getMessage() {
        return "Moeda inválida!";
    }
}
