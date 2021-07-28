/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.IRepositorioUsuario;
import interfaces.ITwitter;
import java.util.ArrayList;

/**
 *
 * @author ISAAC
 */
public class MyTwitter implements ITwitter{
    
    public IRepositorioUsuario repusuarios;
    
    public MyTwitter(IRepositorioUsuario rep){
        this.repusuarios = rep;
    }

    @Override
    public void criarPerfil(Perfil usuario) {
        this.repusuarios.cadastrar(usuario);
    }

    @Override
    public void cancelarPerfil(String usuario) {
        Perfil perfil = this.repusuarios.buscar(usuario);
        perfil.setAtivo(false);
    }

    @Override
    public void tweetar(String usuario, String mensagem) {
        Tweet tweet = new Tweet(usuario, mensagem);
        Perfil perfil = this.repusuarios.buscar(usuario);
        perfil.addTweet(tweet);
        ArrayList<Perfil> seguidores = seguidores(usuario);
        for(Perfil p : seguidores){
            p.addTweet(tweet);
        }
        
    }

    @Override
    public ArrayList<Tweet> timeline(String usuario) {
        Perfil p = this.repusuarios.buscar(usuario);
        return p.getTimeline();
    }

    @Override
    public ArrayList<Tweet> tweets(String usuario) {
        ArrayList<Tweet> tweets = timeline(usuario);
        for(Tweet t : tweets){
            if(t.getUsuario() != usuario)
                tweets.remove(t);
        }
        return tweets;
    }

    @Override
    public void seguir(String seguidor, String seguido) {
        Perfil p = this.repusuarios.buscar(seguido);
        p.addSeguidor(seguidor);
    }

    @Override
    public int numeroSeguidores(String usuario) {
        Perfil p = this.repusuarios.buscar(usuario);
        return p.getSeguidores().size();
    }

    @Override
    public ArrayList<Perfil> seguidores(String usuario) {
        Perfil u = this.repusuarios.buscar(usuario);
        ArrayList<Perfil> seguidores = new ArrayList<>();
        ArrayList<String> s = u.getSeguidores();
        for(String seguidor : s){
            Perfil f = this.repusuarios.buscar(seguidor);
            seguidores.add(f);
        }
        return seguidores;
    }
}
