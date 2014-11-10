/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetocebolutions;

import java.util.Scanner;

/**
 *
 * @author vitor.ccarvalho
 */
public class Aluno {
    private String nome;
    private String cpf;
    private boolean isAluno;
    
    public Aluno (){
        
    }

    
    //public Aluno (String nome, String cpf) {
    //    this.nome = nome;
    //    this.cpf = cpf;    
    //}   
     public void setIsAluno(boolean isAluno) {
         this.isAluno = isAluno;
     }
     public void Usuario(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("");
        System.out.println("----- Cadastro do Usuario ----- ");
        System.out.println("");
        System.out.println("Digite seu nome: ");
        this.nome = entrada.nextLine();
        System.out.println("Digite seu CPF:");
        this.cpf = entrada.nextLine();
        System.out.println("");
        System.out.println("1. Aluno");
        System.out.println("2. Ex-Aluno");
        System.out.print("Digite uma opção: ");
        int isAluno = entrada.nextInt();
        if (isAluno == 1) {
            this.isAluno = true;
        } else if (isAluno == 2) {
            this.isAluno = false;
        } else {
            System.out.println("Opção incorreta!");
        }
     }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the isAluno
     */
    public boolean isAluno() {
        return isAluno;
    }
}
