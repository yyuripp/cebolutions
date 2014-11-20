/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

/**
 *
 * @author pc
 */
public class Adm {
    private String nome; 
    private String password;
    
    public Adm (){
        this.nome = "Jorge Silva";
        this.password = "admin";
    }
    
    public boolean validaPass(String pass){
        if (password.equalsIgnoreCase(pass)) {
            return true;
        } 
        return false;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
}
