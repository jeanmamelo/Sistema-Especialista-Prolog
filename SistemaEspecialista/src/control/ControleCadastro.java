package control;

import database.Banco;
import java.util.ArrayList;
import model.Cadastro;

/**
 *
 * @author Eduardo
 */
public class ControleCadastro {
    Cadastro objCadastro;
   
    public void salvarCadastro(String nome, String endereco, String cidade, String celular, String email, String diagnostico){
        
        objCadastro = new Cadastro(nome, endereco, cidade, celular, email, diagnostico); //Gera um objeto modelCadastro do tipo Cliente que recebe as informações do usuário
        
        Banco.getBanco().add(objCadastro); // Adiciona as informaçoes do usuário na lista (Banco de Dados)
    }
        
    public ArrayList<Integer> procurarPeloNome(String nome, ArrayList<Cadastro> banco) {
        
        ArrayList<Integer> itens = new ArrayList<>();  
        for (int i = 0; i < banco.size(); i++) {//Percorre o vetor de clientes 
            //if (nome.equals(clientes.get(i).getNome())) { 
            if (nome.equalsIgnoreCase(banco.get(i).getNome())){// Se o nome procurado é igual ao nome que esta na lista
            itens.add(i); 
            }
        }
        return itens; //retorna o indice em que o nome esta
    } 
}  

