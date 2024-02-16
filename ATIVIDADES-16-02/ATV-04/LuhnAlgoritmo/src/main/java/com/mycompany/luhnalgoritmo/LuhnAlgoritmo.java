package com.mycompany.luhnalgoritmo;

import java.util.Scanner;

public class LuhnAlgoritmo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número para validar (espaços são permitidos): ");
        String entrada = scanner.nextLine();

        if (validoNumero(entrada)) {
            System.out.println("O número é válido de acordo com a fórmula de Luhn.");
        } else {
            System.out.println("O número não é válido de acordo com a fórmula de Luhn.");
        }
    }

    public static boolean validoNumero(String numero) {
        String numeroOriginal = numero; // Armazena o número original antes da remoção de espaços
        numero = numero.replaceAll("\\s", "");

        if (numero.length() <= 1 || !numero.matches("\\d+")) {
            return false;
        }

        int soma = 0;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));

            if ((numero.length() - i) % 2 == 0) {
                int digitoDobrado = digito * 2;
                soma += (digitoDobrado > 9) ? digitoDobrado - 9 : digitoDobrado;
            } else {
                soma += digito;
            }
        }

        System.out.println("Número original: " + numeroOriginal);
        System.out.println("Número após a remoção de espaços: " + numero);
        System.out.println("Resultados da duplicação: " + duplicacao(numero));
        System.out.println("Soma de cada dígito após a duplicação e ajuste: " + soma);
        return soma % 10 == 0;
    }

    public static String duplicacao(String numero) {
        StringBuilder resultadosDuplicacao = new StringBuilder();

        for (int i = numero.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numero.charAt(i));

            int digitoDobrado = (i % 2 == 0) ? digito : digito * 2;

            if (digitoDobrado > 9) {
                digitoDobrado -= 9;
            }

            resultadosDuplicacao.insert(0, digitoDobrado);
            if (i > 0) {
                resultadosDuplicacao.insert(0, " ");
            }
        }

        return resultadosDuplicacao.toString();
    }
}
