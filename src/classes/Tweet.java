/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author ISAAC
 */
public class Tweet {
    
    private String usuario;
    private String mensagem;
    
    public Tweet(String usuario, String mensagem){
        this.usuario = usuario;
        this.mensagem = mensagem;
    }
    
    public void setUsuario(String u){
        this.usuario = u;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setMensagem(String m){
        this.mensagem = m;
    }
    
    public String getMensagem(){
        return this.mensagem;
    }
    
}
