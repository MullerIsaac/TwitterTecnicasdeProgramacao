/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author ISAAC
 */
public abstract class Perfil {
 
    private String usuario;
    private ArrayList<String> seguidores;
    private ArrayList<Tweet> timeline;
    private Boolean ativo;
    
    public Perfil(String usuario){
        this.usuario = usuario;
        seguidores = new ArrayList<>();
        timeline = new ArrayList<>();
        this.ativo = true;
    }
    
    public void addSeguidor(String seguidor){
        this.seguidores.add(seguidor);
    }
    
    public void addTweet(Tweet t){
        this.timeline.add(t);
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public ArrayList<String> getSeguidores(){
        return this.seguidores;
    }
    
    public ArrayList<Tweet> getTimeline(){
        return this.timeline;
    }
    
    public void setAtivo(Boolean ativo){
        this.ativo = ativo;
    }
    
    public Boolean isAtivo(){
        return this.ativo;
    }
}
