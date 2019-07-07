package control;

import database.Banco;
import java.util.ArrayList;
import java.util.Map;
import model.Cadastro;
import org.jpl7.Query;
import org.jpl7.Term;

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
    
    public void executaProLog(ArrayList<String> sintomas){
        String listaSintoma = criaListaProlog(sintomas);
        
        String c1="consult('sistemaEspecialista.pl')";
        Query q1 = new Query(c1);
        System.out.println("t1 "+ (q1.hasSolution()? "Conectado":"Sem conexão!"));
        String encontraSintoma = "retornaDoenca("+listaSintoma+",Lista)";
        Query q2 = new Query (encontraSintoma);
        Map<String, Term>[] doencas =  q2.allSolutions();     
        for(int i = 0; i<doencas.length; i++){
            System.out.println("Voce tem: "+ doencas[i].get("Lista"));
        }
    }
    public String criaListaProlog(ArrayList<String> sintomas){
        String lista = new String();
        int cont =0;
        String tail = "[";
        if(sintomas.get(0).equals("1 dia")){
            if(cont == 0){
                tail = tail+"febre(1)";
                cont++;
            }else{
                tail = tail+", febre(1)";
            } 
        }
        if(sintomas.get(0).equals("2 dias")){
            if(cont == 0){
                tail = tail+"febre(2)";
                cont++;
            }else{
                tail = tail+", febre(2)";
            } 
        }
        if(sintomas.get(0).equals("3 dias")){
            if(cont == 0){
                tail = tail+"febre(3)";
                cont++;
            }else{
                tail = tail+", febre(3)";
            } 
        }
        if(sintomas.get(0).equals("4 dias")){
            if(cont == 0){
                tail = tail+"febre(4)";
                cont++;
            }else{
                tail = tail+", febre(4)";
            } 
        }
        if(sintomas.get(0).equals("5 dias")){
            if(cont == 0){
                tail = tail+"febre(5)";
                cont++;
            }else{
                tail = tail+", febre(5)";
            } 
        }
        if(sintomas.get(0).equals("6 dias")){
            if(cont == 0){
                tail = tail+"febre(6)";
                cont++;
            }else{
                tail = tail+", febre(6)";
            } 
        }
        if(sintomas.get(0).equals("7 dias")){
            if(cont == 0){
                tail = tail+"febre(7)";
                cont++;
            }else{
                tail = tail+", febre(7)";
            } 
        }
        if(sintomas.get(1).equals("1 dia")){
            if(cont == 0){
                tail = tail+"subFebril(1)";
                cont++;
            }else{
                tail = tail+", subFebril(1)";
            } 
        }
        if(sintomas.get(1).equals("2 dias")){
            if(cont == 0){
                tail = tail+"subFebril(2)";
                cont++;
            }else{
                tail = tail+", subFebril(2)";
            } 
        }
        
        
        tail = tail+"]";
        lista = "[null|"+tail+"]";
        return lista;
    }
}  
