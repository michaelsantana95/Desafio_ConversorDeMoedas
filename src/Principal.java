import challenge.api.exchangeRateApi;
import challenge.api.mensagens;
import challenge.api.moedas.calculaValor;
import challenge.api.moedas.listas.listaConversoes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<listaConversoes> list = new ArrayList<>();

        while (true) {
            exchangeRateApi exchangeRateAPI = new exchangeRateApi();
            calculaValor calculaValor = new calculaValor();

            calculaValor.calculaMoedaPorOpcao(exchangeRateAPI.getConversionRates());
            calculaValor.calculaValorConvertido();

            listaConversoes listaConversoes = new listaConversoes(calculaValor.getMoeda1Nome(),
                    calculaValor.getValor(), calculaValor.getMoeda2Nome(), calculaValor.getValorConvertido());

            list.add(listaConversoes);

            int continuarConvertendo = 0;
            System.out.print(mensagens.mensagemContinuarConvertendo);
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    continuarConvertendo = scanner.nextInt();
                    if (continuarConvertendo == 0) {
                        System.exit(0);
                    } else if (continuarConvertendo == 1) {
                        break;
                    } else if (continuarConvertendo == 2) {
                        System.out.println("\nHistórico de conversões realizadas:");
                        for (challenge.api.moedas.listas.listaConversoes conversoes : list) {
                            System.out.println(conversoes);
                        }
                        System.out.print(mensagens.mensagemContinuarConvertendo);
                    } else {
                        System.out.print("Escolha uma opção válida: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Escolha uma opção válida: ");
                }
            }
        }
    }
}