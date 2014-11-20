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
        short[] respS = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //RelacaoSatisfacaoPerguntaDAO rsp = new RelacaoSatisfacaoPerguntaDAO();
        //rsp.iniciarConexao();
        //rsp.inserirResp(respS, "1234");
        //rsp.encerraConexao();
    }
    public RelacaoSatisfacaoPerguntaDAO (){
        
    }
    public void inserirResp(short[] respSatis, String cpf) {
        short idAluno = 1;
        ResultSet perg;
        try {
            perg = stmt.executeQuery("SELECT idAluno FROM tblAluno WHERE CPFAluno like '"+cpf+"'");
            while (perg.next()) {
                idAluno = perg.getShort("idAluno");
            }
            
        } catch (SQLException ex) {
            System.out.println("");
        }

        try {
            short j = 1;
            for (int i = 0; i < 10; i++) {
                cs = conn.prepareCall("{call USI_RelacaoSatisfacaoPerguntas(?,?,?)}");
                cs.setShort(1, respSatis[i]);
                cs.setShort(2, j);
                cs.setShort(3, idAluno);
                cs.execute();
                j++;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Não foi possível inserir.");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
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
