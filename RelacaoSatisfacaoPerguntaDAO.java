/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import static projetocebolutions.AlunoDAO.conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoinformacao
 */
public class RelacaoSatisfacaoPerguntaDAO {

    static Scanner sc = new Scanner(System.in);
    static Connection conn;
    static Statement stmt;
    static CallableStatement cs = null;

    public static void main(String[] args) {

    }

    public static void inserirResp(char[] resp) {
        short count = 0;
        ResultSet perg;
        try {
            perg = stmt.executeQuery("SELECT COUNT(1) total FROM tblAluno");
            count = perg.getShort("total");
        } catch (SQLException ex) {
            System.out.println("");
        }

        try {
            
            cs = conn.prepareCall("{call USI_RelacaoSatisfacaoPerguntas(?,?,?)}");
            GrauSatisfacao s = new GrauSatisfacao();
            short respSatis [] = s.getResp();
            for (short i = 1; i <= 10; i++) {
                    cs.setShort(1, i);
                    cs.setShort(2, respSatis[i]);
                    cs.setShort(3, count);
            }
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
