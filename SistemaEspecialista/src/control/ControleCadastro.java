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
        
        System.out.println("Nome: " + nome + "Endereço: " + endereco + "Cidade: " + cidade + "Celular: " + 
                celular + "E-mail: " + email + "Diagnostico: " + diagnostico);
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
    
    public Map<String, Term>[] executaProLog(ArrayList<String> sintomas){
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
        return doencas;
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
        if(sintomas.get(2).equals("Sim, leve")){
            if(cont == 0){
                tail = tail+"dorArticulacao(leve)";
                cont++;
            }else{
                tail = tail+", dorArticulacao(leve)";
            } 
        }
        if(sintomas.get(2).equals("Sim, moderada")){
            if(cont == 0){
                tail = tail+"dorArticulacao(moderada)";
                cont++;
            }else{
                tail = tail+", dorArticulacao(moderada)";
            } 
        }
        if(sintomas.get(2).equals("Sim, intensa")){
            if(cont == 0){
                tail = tail+"dorArticulacao(intensa)";
                cont++;
            }else{
                tail = tail+", dorArticulacao(intensa)";
            } 
        }
        if(sintomas.get(3).equals("Sim, leve")){
            if(cont == 0){
                tail = tail+"inchacoArticulacao(leve)";
                cont++;
            }else{
                tail = tail+", inchacoArticulacao(leve)";
            } 
        }
        if(sintomas.get(3).equals("Sim, intensa")){
            if(cont == 0){
                tail = tail+"inchacoArticulacao(intensa)";
                cont++;
            }else{
                tail = tail+", inchacoArticulacao(intensa)";
            } 
        }
        if(sintomas.get(4).equals("Sim, leve")){
            if(cont == 0){
                tail = tail+"coceira(leve)";
                cont++;
            }else{
                tail = tail+", coceira(leve)";
            } 
        }
        if(sintomas.get(4).equals("Sim, moderada")){
            if(cont == 0){
                tail = tail+"coceira(moderada)";
                cont++;
            }else{
                tail = tail+", coceira(moderada)";
            } 
        }
        if(sintomas.get(4).equals("Sim, intensa")){
            if(cont == 0){
                tail = tail+"coceira(intensa)";
                cont++;
            }else{
                tail = tail+", coceira(intensa)";
            } 
        }
        if(sintomas.get(5).equals("Sim, leve")){
            if(cont == 0){
                tail = tail+"hipertrofia(leve)";
                cont++;
            }else{
                tail = tail+", coceira(leve)";
            } 
        }
        if(sintomas.get(5).equals("Sim, moderada")){
            if(cont == 0){
                tail = tail+"hipertrofia(moderada)";
                cont++;
            }else{
                tail = tail+", coceira(moderada)";
            } 
        }
        if(sintomas.get(5).equals("Sim, intensa")){
            if(cont == 0){
                tail = tail+"hipertrofia(intensa)";
                cont++;
            }else{
                tail = tail+", coceira(intensa)";
            } 
        }
        if(sintomas.get(6).equals("Sim, moderada")){
            if(cont == 0){
                tail = tail+"dorCabeca(moderada)";
                cont++;
            }else{
                tail = tail+", dorCabeca(moderada)";
            } 
        }
        if(sintomas.get(6).equals("Sim, intensa")){
            if(cont == 0){
                tail = tail+"dorCabeca(intensa)";
                cont++;
            }else{
                tail = tail+", dorCabeca(intensa)";
            } 
        }
        if(sintomas.get(7).equals("Sim")){
            if(cont == 0){
                tail = tail+"manchaPele";
                cont++;
            }else{
                tail = tail+", manchaPele";
            } 
        }
        if(sintomas.get(8).equals("Sim")){
            if(cont == 0){
                tail = tail+"dorCorpo";
                cont++;
            }else{
                tail = tail+", dorCorpo";
            } 
        }
        if(sintomas.get(9).equals("Sim")){
            if(cont == 0){
                tail = tail+"nauseaVomito";
                cont++;
            }else{
                tail = tail+", nauseaVomito";
            } 
        }
        if(sintomas.get(10).equals("Sim")){
            if(cont == 0){
                tail = tail+"dorMuscular";
                cont++;
            }else{
                tail = tail+", dorMuscular";
            } 
        }
        if(sintomas.get(11).equals("Sim")){
            if(cont == 0){
                tail = tail+"faltaApetite";
                cont++;
            }else{
                tail = tail+", faltaApetite";
            } 
        }
        if(sintomas.get(11).equals("Sim")){
            if(cont == 0){
                tail = tail+"conjutivite";
                cont++;
            }else{
                tail = tail+", conjutivite";
            } 
        }
        if(sintomas.get(12).equals("Sim")){
            if(cont == 0){
                tail = tail+"calafrios";
                cont++;
            }else{
                tail = tail+", calafrios";
            } 
        }
        if(sintomas.get(13).equals("Sim")){
            if(cont == 0){
                tail = tail+"tremor";
                cont++;
            }else{
                tail = tail+", tremor";
            } 
        }
        if(sintomas.get(14).equals("Sim")){
            if(cont == 0){
                tail = tail+"fadigaFraqueza";
                cont++;
            }else{
                tail = tail+", fadigaFraqueza";
            } 
        }
        if(sintomas.get(15).equals("Sim")){
            if(cont == 0){
                tail = tail+"sudorese";
                cont++;
            }else{
                tail = tail+", sudorese";
            } 
        }
        tail = tail+"]";
        lista = "[padrao|"+tail+"]";
        return lista;
    }
}  
