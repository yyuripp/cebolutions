/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cebolutionsbeta1;

/**
 *
 * @author vitor.ccarvalho
 */
public class Aluno {
    private String nome;
    String cpf;
    boolean isAluno;
    
    public Aluno (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;    
    }   
     public void setIsAluno(boolean isAluno) {
         this.isAluno = isAluno;
     }
}
