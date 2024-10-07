package exceptions;

public class MoedaNaoEncontradaException extends RuntimeException {

    @Override
    public String toString() {
        return "Moeda não econtrada.";
    }
}
