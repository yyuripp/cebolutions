/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cebolutionsbeta1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vitor.ccarvalho
 */
public class Conexao {

    private String host, user, pass, database;

    public Connection c;

    public Conexao(String host, String database, String user, String pass) {
        this.host = host;
        this.database = database;
        this.pass = pass;
        this.user = user;
    }

    public boolean Connection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean isConexao = false;
        String url, portNumber = "1433", userName = this.user, passName = this.pass;
        url = "jdbc:sqlserver://" + this.host + ":" + portNumber + ";DB_Cebolutions = " + this.database;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.c = DriverManager.getConnection(url, userName, passName);
            isConexao = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel conectar ao banco." + e.getMessage());
            isConexao = false;
        }
        return isConexao;
    }

    public boolean Disconnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean isConexao = true;
        String url, portNumber = "1433", userName = this.user, passName = this.pass;
        url = "jdbc:sqlserver://" + this.host + ":" + portNumber + ";DB_Cebolutions = " + this.database;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.c = DriverManager.getConnection(url, userName, passName);
            this.c.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar ao banco." + e.getMessage());
            isConexao = false;
        }
        return isConexao;
    }

    public ResultSet executar(String query) {
        Statement st;
        ResultSet rs;

        try {
            st = this.c.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
