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
        Aluno aluno = new Aluno();
        Adm adm = new Adm();
        Menulogin(aluno, adm);
        
        
        
    }

    static void Menulogin(Aluno a, Adm adm) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("----- MENU -----");
        System.out.println("");
        System.out.println("1. Usuario");
        System.out.println("2. ADM");
        System.out.println("");
        System.out.print("Digite uma opção: ");
        int x = entrada.nextInt();
        if (x == 1) {
            acessoAluno(a);
        } else if (x == 2) {
            acessoAdm(adm);
        } else {
            System.out.println("Opção incorreta!");
        }
    }
    static void acessoAluno (Aluno aluno){
        aluno.Usuario();
        
        System.out.println(aluno.getNome());
        System.out.println(aluno.getCpf());
        System.out.println(aluno.isAluno());
        
        AlunoDAO.iniciarConexao();
        AlunoDAO.inserirAluno(aluno);
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
        RelacaoSatisfacaoPerguntaDAO rsp = new RelacaoSatisfacaoPerguntaDAO();
        rsp.iniciarConexao();
        rsp.inserirResp(s.getResp(), aluno.getCpf());
        rsp.encerraConexao();
    }
    static void acessoAdm (Adm adm){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe sua senha: ");
        String senha = entrada.nextLine();
        boolean validacao = adm.validaPass(senha);
        if (validacao) {
            System.out.println("Bem Vindo Sr(a) "+adm.getNome());
        } else {
            System.out.println("Senha Inválida.");
        }
    }
}
