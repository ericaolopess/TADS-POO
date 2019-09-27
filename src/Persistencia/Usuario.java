/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author erica
 */
public class Usuario {
    
    private String cpf;
    private String nome;
    private String email;
    private String usuario;
    private String senha;
    private boolean redefineSenha;

    
    public Usuario()
    {
        
    }
    
    public Usuario(String cpf, String nome, String email,
            String usuario, String senha, boolean redefineSenha)
    {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.redefineSenha = redefineSenha;
                
    }
    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the redefineSenha
     */
    public boolean isRedefineSenha() {
        return redefineSenha;
    }

    /**
     * @param redefineSenha the redefineSenha to set
     */
    public void setRedefineSenha(boolean redefineSenha) {
        this.redefineSenha = redefineSenha;
    }
    
    
    
    
    
}
