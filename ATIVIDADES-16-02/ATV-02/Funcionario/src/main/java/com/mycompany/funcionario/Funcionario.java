package com.mycompany.funcionario;
import java.util.Scanner; 
                                                                                                          
    public class Funcionario { //definir todos os atributos 
    
    String nome;
    double salario_Inic;
    int faltas; 
    int vendas;
    
    public Funcionario (String nome, double salario_Inic, int faltas, int vendas){ //construtor
    this.nome = nome;
    this.salario_Inic = salario_Inic;
    this.faltas = faltas;
    this.vendas = vendas;
    }

    public double calcularSalario() { // como sera feito o salario do funcionario 
        double desc_faltas = (faltas > 5) ? 0.15 * salario_Inic : 0;
        double comissao = (vendas > 20) ? 13 * vendas : 10 * vendas;
        
        return salario_Inic - desc_faltas + comissao;
    }
        
    public String getNome(){
            return nome;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Digite o nome do funcionario: ");
        String nomeFuncionario = scanner.nextLine();
        
        System.out.println("Digite o Salario Inicial do Funcionario: ");
        double salario_Inic = scanner.nextDouble(); 
      
        System.out.println("Digite as vendas do funcionario: ");
        int vendas = scanner.nextInt();
        
        System.out.println("Quantas faltas o funcionario teve: ");
        int faltas = scanner.nextInt();
        //objeto funcionario
        Funcionario funcionario = new Funcionario (nomeFuncionario, salario_Inic, faltas , vendas);
        
        //calculo final 
        double salarioF = funcionario.calcularSalario();
       System.out.printf("O salario final de %s é: R$%.2f%n", funcionario.getNome(), salarioF);
    }
}