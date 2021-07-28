/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Perfil;
import exceptions.UJCException;

/**
 *
 * @author ISAAC
 */
public interface IRepositorioUsuario {
    
    public void cadastrar(Perfil usuario) throws UJCException;
    public Perfil buscar(String usuario);
    public void atualizar(Perfil usuario);
}
