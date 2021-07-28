/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.*;
import interfaces.IRepositorioUsuario;
import interfaces.ITwitter;
import java.util.ArrayList;
import jdk.nashorn.internal.parser.TokenType;

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
    public void criarPerfil(Perfil usuario) throws PEException {
        try{
            this.repusuarios.cadastrar(usuario);
        }catch(UJCException e){
            throw new PEException(e.username());
        }
    }

    @Override
    public void cancelarPerfil(String usuario) throws PIException, PDException {
        Perfil perfil = this.repusuarios.buscar(usuario);
        if(perfil == null)
            throw new PIException(usuario);
        else{
            if(perfil.isAtivo())
               perfil.setAtivo(false);
            else
                throw new PDException((usuario));
        }
        
    }

    @Override
    public void tweetar(String usuario, String mensagem)throws PIException, MFPException {
        if(mensagem.length()<1 || mensagem.length() > 140){
            throw new MFPException(mensagem);
        }
        Tweet tweet = new Tweet(usuario, mensagem);
        Perfil perfil = this.repusuarios.buscar(usuario);
        
        if(perfil == null)
            throw new PIException(usuario);
        perfil.addTweet(tweet);
        ArrayList<Perfil> seguidores = seguidores(usuario);
        for(Perfil p : seguidores){
            p.addTweet(tweet);
        }
        
    }

    @Override
    public ArrayList<Tweet> timeline(String usuario) throws PIException, PDException{
        Perfil p = this.repusuarios.buscar(usuario);
        if(p == null)
            throw new PIException(usuario);
        else if(p.isAtivo())
            return p.getTimeline();
        else
            throw new PDException(usuario);
    }

    @Override
    public ArrayList<Tweet> tweets(String usuario) throws PIException, PDException {
        try{
            ArrayList<Tweet> tweets = timeline(usuario);
            for(Tweet t : tweets){
                if(t.getUsuario() != usuario)
                    tweets.remove(t);
            }
            return tweets;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void seguir(String seguidor, String seguido) throws PIException, PDException{
        Perfil s = this.repusuarios.buscar(seguidor);
        Perfil p = this.repusuarios.buscar(seguido);
        if(s == null)
            throw new PIException(seguidor);
        if(p == null)
            throw new PIException(seguido);
        if(!s.isAtivo())
            throw new PDException(seguidor);
        if(!p.isAtivo())
            throw new PDException(seguido);
        
        
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
