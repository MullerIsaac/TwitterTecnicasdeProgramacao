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
public class MFPException extends Exception{
    private String mensagem;
    
    public MFPException(String mensagem){
        super("A mensagem deve conter entre 1 e 140 caracteres");
        this.mensagem = mensagem;
    }
    
    public String mensagem(){
        return this.mensagem;
    }
}
