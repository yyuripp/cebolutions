/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class ProjetoCebolutions {

    
    private static Object callableStatement;

    public static void main(String[] args) {
Menulogin();

        AlunoDAO.iniciarConexao();
        AlunoDAO.inserirAluno();
        AlunoDAO.encerraConexao();

        Perguntas p = new Perguntas();
        p.iniciarConexao();
        p.perguntas();
        p.encerraConexao();

        GrauSatisfacao s = new GrauSatisfacao();
        s.iniciarConexao();
        s.satisfacao();
        s.encerraConexao();

        for (int i = 0; i < 10; i++) {
            Scanner entrada = new Scanner(System.in);
            short a = 1;
            short b = 2;
            short c = 3;
            short d = 4;
            short e = 5;
            p.imprimePerguntas(i);
            s.imprimeSatisfacao();
            char x = entrada.next().charAt(0);
            if (x == 'A' || x == 'a') {
                s.setResp(i, a);
            } else if (x == 'B'|| x == 'b' ) {
                s.setResp(i, b);
            } else if (x == 'C'|| x == 'c' ) {
                s.setResp(i, c);
            } else if (x == 'D'|| x == 'd') {
                s.setResp(i, d);
            } else if (x == 'E'|| x == 'e') {
                s.setResp(i, e);
            }
        }
    }

    static void Menulogin() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("----- MENU -----");
        System.out.println("");
        System.out.println("1. Usuario");
        System.out.println("2. ADM");
        System.out.println("");
        System.out.print("Digite uma opção: ");
        int x = entrada.nextInt();
        if (x == 1) {
            Aluno a = new Aluno();
            a.Usuario();
        } else if (x == 2) {

        } else {
            System.out.println("Opção incorreta!");
        }
    }
    
}
