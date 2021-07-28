/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Perfil;
import classes.Tweet;
import java.util.ArrayList;

/**
 *
 * @author ISAAC
 */
public interface ITwitter {
    
    public void criarPerfil(Perfil usuario);
    public void cancelarPerfil(String usuario);
    public void tweetar(String usuario, String mensagem);
    public ArrayList<Tweet> timeline(String usuario);
    public ArrayList<Tweet> tweets(String usuario);
    public void seguir(String seguidor, String seguido);
    public int numeroSeguidores(String usuario);
    public ArrayList<Perfil> seguidores(String usuario);
    
}
