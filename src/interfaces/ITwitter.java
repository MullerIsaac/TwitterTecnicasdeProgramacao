/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Perfil;
import classes.Tweet;
import exceptions.*;
import java.util.ArrayList;

/**
 *
 * @author ISAAC
 */
public interface ITwitter {
    
    public void criarPerfil(Perfil usuario)throws PEException;
    public void cancelarPerfil(String usuario)throws PIException, PDException;
    public void tweetar(String usuario, String mensagem)throws PIException, MFPException;
    public ArrayList<Tweet> timeline(String usuario)throws PIException, PDException;
    public ArrayList<Tweet> tweets(String usuario)throws PIException, PDException;
    public void seguir(String seguidor, String seguido)throws PIException, PDException;
    public int numeroSeguidores(String usuario);
    public ArrayList<Perfil> seguidores(String usuario);
    
}
