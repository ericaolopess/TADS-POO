/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyConnection {
    
    public Statement stm;
    public ResultSet rs;
    public Connection conn;
    public PreparedStatement pst;
    
    private String driver;
    private String caminho;
    private String usuario;
    private String senha;
    
    public void conectar()
    {
        driver = "org.mysql.jdbc.Driver";
        caminho = "jdbc:mysql://localhost:3306/fiverings";
        usuario = "root";
        senha = "";
            
        try {
            System.setProperty("jdbc.Drives", driver);
            conn = DriverManager.getConnection
                            (caminho, usuario, senha);
            JOptionPane.showMessageDialog
               (null, "Conexao realizada com sucesso!!!");
                  
        } catch (SQLException erro) {
            Logger.getLogger(MyConnection.class.getName())
                    .log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog
               (null, "ERRO DE CONEXÃO!!!");
        }
    }
    
    public void desconectar()
    {
        try 
        {
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
    public static void main (String [] args)
    {
           MyConnection conecta = 
                        new MyConnection();
           conecta.conectar();
           
    }
    
    
    
}



