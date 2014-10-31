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
public class Perguntas {

    public void populaVetor(String[] perguntas) {
        perguntas[0] = "Pergunta 1";
        perguntas[1] = "Pergunta 2";
        perguntas[2] = "Pergunta 3";
        perguntas[3] = "Pergunta 4";
        perguntas[4] = "Pergunta 5";
        perguntas[5] = "Pergunta 6";
        perguntas[6] = "Pergunta 7";
        perguntas[7] = "Pergunta 8";
        perguntas[8] = "Pergunta 9";
        perguntas[9] = "Pergunta 10";
    }

    public char[] perguntasUsuario(String[] perguntas) {
        Scanner entrada = new Scanner(System.in);
        char[] res = new char[10];
        for (int i = 0; i < perguntas.length; i++) {
            System.out.println(perguntas[i]);
            System.out.println("A. Muito bom");
            System.out.println("B. Bom");
            System.out.println("C. Regular");
            System.out.println("D. Ruim");
            System.out.println("E. Muito Ruim");
            System.out.println("");
            System.out.print("Resposta: ");
            res[i] = entrada.next().charAt(0);
        }
        return res;
    }
}
