/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetocebolutions;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author geoinformacao
 */
public class AlunoDAO {
    
    static Scanner sc = new Scanner(System.in);
    static Connection conn;
    static Statement stmt;
    static CallableStatement cs = null;
    
    public static void main(String[] args) {
    }
    
    public static void inserirAluno() {
        Aluno a = new Aluno();
        String nomeAluno = a.getNome();
        String CPFAluno = a.getCpf();
        boolean isAluno = a.isAluno();
        short tipoAluno;
        if (isAluno) {
            tipoAluno = 1;
        } else {
            tipoAluno = 2;
        }
        try {
            cs = conn.prepareCall("{call USI_Aluno(?,?,?)}");
            cs.setString(1, nomeAluno);
            cs.setString(2, CPFAluno);
            cs.setShort(3, tipoAluno);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Não foi possível inserir.");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public static void iniciarConexao() {
        Conexao conexao = new Conexao();
        try {
            conn = conexao.getConexao();
            stmt = conn.createStatement();
            System.out.println("Conexão Realizada com sucesso");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public static void encerraConexao() {
        Conexao conexao = new Conexao();
        try {
            conn.close();
            stmt.close();
            System.out.println("Goodbye");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
