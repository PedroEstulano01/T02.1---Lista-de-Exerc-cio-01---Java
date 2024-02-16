package com.mycompany.numerosestatisticas;
import java.util.Scanner;

public class NumerosEstatisticas {
    public static void main(String[] args) {
        
       Scanner numero_estaticas = new Scanner(System.in);
       
       int numero;
       int quantidade= 0; 
       int soma = 0;
       int maior = Integer.MIN_VALUE;
       int menor = Integer.MAX_VALUE;
               
       System.out.println("Digite os numeros inteiros (digite -1 para encerrar): ");
       
       while(true) {
           numero = numero_estaticas.nextInt();
           if (numero == -1){
               break;
           }
           
           quantidade ++;
           soma += numero;
           maior = Math.max(maior, numero);
           menor = Math.min(menor, numero);
       }
       
       double media = (quantidade > 0) ? (double) soma / quantidade : 0;
       
       System.out.println("Quantidade de números digitados: " + quantidade);
       System.out.println("Maior Número digitado: " + ((quantidade >0)? maior : "Nenhum número digitado"));
       System.out.println("Menor número digitado: " + ((quantidade > 0) ? menor : "Nenhum número digitado"));
       System.out.println("Média dos números digitados: " + media);
  }
} 
