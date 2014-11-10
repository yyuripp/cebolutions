/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import java.util.Scanner;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor.ccarvalho
 */
public class Conexao {

    public Conexao() {
    }
    public Connection getConexao() {
        Connection conn = null;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=DB_CEBOLUTIONS;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection(connectionUrl, "cebolutions", "cebolutions");
            System.out.println("Conexão obtido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao banco: " + e);
        }
        return conn;
    }
}
