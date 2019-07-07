package database;

import java.util.ArrayList;
import model.Cadastro;

/**
 *
 * @author Eduardo
 */
public class Banco {
   
    private static ArrayList<Cadastro> banco = new ArrayList<>(); 
  
    /**
     *
     * @returns the user registration list 
     */
    public static ArrayList<Cadastro> getBanco() 
    {
        return banco;
    }
}    

