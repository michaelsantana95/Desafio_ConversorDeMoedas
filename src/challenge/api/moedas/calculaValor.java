package challenge.api.moedas;

import challenge.api.mensagens;

import java.util.InputMismatchException;
import java.util.Scanner;

public class calculaValor {
    private double moeda1Valor;
    private String moeda1Nome;
    private double moeda2Valor;
    private String moeda2Nome;
    private boolean primeiraMoeda = true;
    private String moedaNome;
    private double moedaValor;
    private double valor;
    private double valorConvertido;

    public String getMoeda1Nome() {
        return moeda1Nome;
    }

    public String getMoeda2Nome() {
        return moeda2Nome;
    }

    public double getValor() {
        return valor;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void calculaMoedaPorOpcao(taxasDeConversao taxasDeConversao) {
        moedaValor = 0;
        if (primeiraMoeda) {
            System.out.print(mensagens.mensagemMoedaOpcoes.formatted(mensagens.moeda1));
        } else {
            System.out.print(mensagens.mensagemMoedaOpcoes.formatted(mensagens.moeda2));
        }
        while (moedaValor == 0) {
            try {
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        moedaValor = taxasDeConversao.conversionRates().get("usd");
                        moedaNome = "USD";
                        break;
                    case 2:
                        moedaValor = taxasDeConversao.conversionRates().get("brl");
                        moedaNome = "BRL";
                        break;
                    case 3:
                        moedaValor = taxasDeConversao.conversionRates().get("aoa");
                        moedaNome = "AOA";
                        break;
                    case 4:
                        moedaValor = taxasDeConversao.conversionRates().get("jpy");
                        moedaNome = "JPY";
                        break;
                    case 5:
                        moedaValor = taxasDeConversao.conversionRates().get("eur");
                        moedaNome = "EUR";
                        break;
                    case 6:
                        moedaValor = taxasDeConversao.conversionRates().get("gbp");
                        moedaNome = "GBP";
                        break;
                    case 0:
                        System.exit(0);
                }
                if (moedaValor != 0) {
                    break;
                } else {
                    System.out.print("Digite uma opção válida: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Digite uma opção válida: ");
            }
        }
        if (primeiraMoeda) {
            moeda1Nome = moedaNome;
            moeda1Valor = moedaValor;
            primeiraMoeda = false;
            calculaMoedaPorOpcao(taxasDeConversao);
        } else {
            moeda2Nome = moedaNome;
            moeda2Valor = moedaValor;
        }
    }

    public void calculaValorConvertido() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagens.mensagemValorConverte);
        valor = 0;
        while (true) {
            try {
                valor = scanner.nextDouble();
                if (valor == 0) {
                    System.out.print("Digite um valor válido: ");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Digite um valor válido: ");
                scanner.nextLine();
            }
        }
        valorConvertido = 1 / moeda1Valor * valor * moeda2Valor;
        System.out.println();
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Câmbio = $ " + (1 / moeda1Valor * moeda2Valor));
        System.out.println();
        System.out.println("$ " + valor + " " + moeda1Nome + " para " + moeda2Nome + " = $ " + valorConvertido);
    }
}