package challenge.api;

public class mensagens {
    public static String moeda1 = "Qual moeda você possui?";
    public static String moeda2 = "Para qual moeda você gostaria de converter?";

     public static String mensagemMoedaOpcoes = """
            
            ***************************************
            1 - USD -> Dólar Americano
            2 - BRL -> Real Brasileiro
            3 - AOA -> Kwanza Angolano
            4 - JPY -> Iene Japonês
            5 - EUR -> Euro
            6 - GBP -> Libra Esterlina
            
            0 - Sair
            ***************************************
            %s
            Opção:\s""";

    public static String mensagemValorConverte = """
            ***************************************
            Qual o valor a ser convertido?
                        Valor: $\s""";

    public static String mensagemContinuarConvertendo = """                           
            
            ***************************************
            1 - Converter outra moeda
            2 - Mostrar moedas convertidas
            
            0 - Sair
            ***************************************
            O que deseja fazer agora?
            Opção:\s""";
}