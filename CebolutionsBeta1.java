/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cebolutionsbeta1;

import java.util.Scanner;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author vitor.ccarvalho
 */
public class CebolutionsBeta1 {

    private static Object callableStatement;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConexao();
        CallableStatement pstmt = null;
        Statement stmt = null;
        
        //PreparedStatement pstmt = null;
        try {
            /*
            pstmt = conn.prepareCall("{call uspListPerguntas(?)}");
            pstmt.registerOutParameter(1, Types.VARCHAR);
            pstmt.setInt(1, 1);
            pstmt.execute();
            String result = pstmt.getNString(1);
            System.out.println(result);
            */
            
            //perguntass(conn, 1);
            //ResultSet result = stmt.execute();
            //ResultSet result = stmt.executeQuery();
            //System.out.println(result);
            
            
            stmt = conn.createStatement();
            
                ResultSet perg = stmt.executeQuery("SELECT descricao FROM tblPerguntas WHERE idPergunta = 1" );
                
                while (perg.next()) {
                    String pergunta = perg.getString("descricao");
                    System.err.println("PERGUNTA -> " + pergunta + "\n");
                } 
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }/*finally{
         //finally block used to close resources
         try{
         if(stmt!=null)
         stmt.close();
         }catch(SQLException se2){
         }// nothing we can do
         try{
         if(conn!=null)
         conn.close();
         }catch(SQLException se){
         se.printStackTrace();
         }//end finally try
         }//end try*/
            
        System.out.println("Goodbye!");
        //Aluno a = Menulogin();
        //perguntasUsuario();
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
        String nome, cpf;
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
        Aluno aluno = new Aluno(nome, cpf);
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
