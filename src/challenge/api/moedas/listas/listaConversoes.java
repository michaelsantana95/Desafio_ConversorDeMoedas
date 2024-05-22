package challenge.api.moedas.listas;

public record listaConversoes(String moeda1, double quantidade, String moeda2, Double valorConvertido) {

    @Override
    public String toString() {
        return "$ " + quantidade + " " + moeda1 + " para " + moeda2 + " = $ " + valorConvertido;
    }
}