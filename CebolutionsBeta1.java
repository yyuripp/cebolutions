/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cebolutionsbeta1;

import java.util.Scanner;

/**
 *
 * @author vitor.ccarvalho
 */
public class CebolutionsBeta1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aluno a = Menulogin();
        perguntasUsuario();
    }

    static Aluno Menulogin() {
        Scanner entrada = new Scanner(System.in);
        Aluno a = null;
        System.out.println("----- MENU -----");
        System.out.println("");
        System.out.println("1. Usuario");
        System.out.println("2. ADM");
        System.out.println("");
        System.out.print("Digite uma opção: ");
        int x = entrada.nextInt();
        if (x == 1) {
            a = Usuario();
        } else if (x == 2) {

        } else {
            System.out.println("Opção incorreta!");
        }
        return a;
    }

    static Aluno Usuario() {
        Scanner entrada = new Scanner(System.in);
        int isAluno;
        String nome,cpf;
        System.out.println("");
        System.out.println("----- Cadastro do Usuario ----- ");
        System.out.println("");
        System.out.println("Digite seu nome: ");
        nome = entrada.nextLine();
        System.out.println("Digite seu CPF:");
        cpf = entrada.nextLine();
        System.out.println("");
        System.out.println("1. Aluno");
        System.out.println("2. Ex-Aluno");
        System.out.print("Digite uma opção: ");
        isAluno = entrada.nextInt();
        Aluno aluno = new Aluno(nome,cpf);
        if (isAluno == 1) {
            aluno.setIsAluno(true);
        } else if (isAluno == 2) {
            aluno.setIsAluno(false);
        } else {
            System.out.println("Opção incorreta!");
        }
        return aluno;
    }

    static void perguntasUsuario() {
        Perguntas pergunta = new Perguntas();
        String[] perguntas = new String[10];
        pergunta.populaVetor(perguntas);
        char[] res = pergunta.perguntasUsuario(perguntas);
    }
}