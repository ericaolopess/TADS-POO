/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import Persistencia.Usuario;

/**
 *
 * @author erica
 */
public class UsuarioDAO extends MyConnection
{

    private ResultSet rs;
    

    public int salvar(Usuario usu)
    {
        conectar();
        try {
            pst = conn.prepareStatement("insert into usuario " +
                    "(CPF, EMAIL, USUARIO, SENHA, REDEFINESENHA)" +
                    " VALUES (?, ?, ?, ?, ?)");
            
            pst.setString(1, usu.getCpf());
            pst.setString(3, usu.getEmail());
            pst.setString(4, usu.getUsuario());
            pst.setString(5, usu.getSenha());
            pst.setBoolean(6, usu.isRedefineSenha());
            
            int retorno = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
           
            return retorno;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;  
        }      
    }
    

}
