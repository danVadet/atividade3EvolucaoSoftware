/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HelbertMonteiro
 */
public class Banco {
    private static final String banco      = "jdbc:mysql://127.0.0.1/ThorEnt";
    private static final String usuario    = "root";
    private static final String senha      = "";
    private static final String driver     = "com.mysql.jdbc.Driver";
    private static Connection   connection = null;
    
    public static Connection getConexao(){
        if (connection == null){
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(banco, usuario, senha);
            } catch (ClassNotFoundException error) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException error) {
                System.out.println("Erro ao conectar: " + error.getMessage());
            }
        }
        return connection;
    }
    
    public static PreparedStatement getPreparedStatement(String sql){
        if(connection == null){
            connection = getConexao();
        }
        try{
            return connection.prepareStatement(sql);
        }catch(SQLException error){
            System.out.println("Erro de sql: " + error.getMessage());
        }
        return null;
    }
}
