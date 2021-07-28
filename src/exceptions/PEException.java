/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author ISAAC
 */
public class PEException extends Exception{
    private String username;
    
    public PEException(String username){
        super("Nome de usuário "+username +" já cadastrado");
        this.username = username;
    }
    
    public String username(){
        return this.username;
    }
}
