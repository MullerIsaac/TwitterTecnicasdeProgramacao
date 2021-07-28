/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import sun.nio.cs.ext.TIS_620;

/**
 *
 * @author ISAAC
 */
public class UJCException extends Exception{
    private String username;
    
    public UJCException(String username){
        super("Nome de usuário já cadastrado");
        this.username = username;
    }
    
    public String username(){
        return this.username;
    }
}
