/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author vitor.ccarvalho
 */
public class Perguntas {
    
    static Connection conn;
    static Statement stmt;
    private String[] perguntas = new String[10];
    
    private int i = 0;
    
    public void populaVetor(String perg) {
        perguntas[i] = perg;
        i++;
    }
    
    public void perguntas(){
        try {

            stmt = conn.createStatement();
            ResultSet perg = stmt.executeQuery("SELECT * FROM tblPerguntas");

            while (perg.next()) {
                String perguntas = perg.getString("descricao");
                populaVetor(perguntas);
            }

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String [] getPerguntas() {
        return perguntas;
    }
    public void imprimePerguntas(int i){
            System.out.println(perguntas[i]);
    }
    public void iniciarConexao() {
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
    
    public void encerraConexao() {
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
