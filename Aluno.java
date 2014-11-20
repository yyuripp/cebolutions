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
   
     public void setIsAluno(boolean isAluno) {
         this.isAluno = isAluno;
     }
     
     public void Usuario(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("");
        System.out.println("----- Cadastro do Usuario ----- ");
        System.out.println("");
        System.out.println("Digite seu nome: ");
        this.setNome(entrada.nextLine());
        System.out.println("Digite seu CPF:");
        this.setCpf(entrada.nextLine());
        System.out.println("");
        System.out.println("1. Aluno");
        System.out.println("2. Ex-Aluno");
        System.out.print("Digite uma opção: ");
        int isAluno = entrada.nextInt();
        if (isAluno == 1) {
            setIsAluno(true);
        } else if (isAluno == 2) {
            setIsAluno(false);
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

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
