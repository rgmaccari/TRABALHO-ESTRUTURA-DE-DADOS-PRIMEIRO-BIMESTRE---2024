package com.mycompany.trabalhoestruturadedados1obimestre;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TrabalhoEstruturaDeDados1oBimestre {

    public static void main(String[] args) {
        int opcao;
        String verificar;
        
        do{
            String input = JOptionPane.showInputDialog
            (null, "ESCOLHA A OPÇÃO DESEJADA:"
                             + "\n1) Ordenação por inserção."
                             + "\n2) Ordenação por seleção."
                             + "\n3) Ordenação bolha."
                             + "\n4) Sair");
            
            opcao = Integer.parseInt(input);
            
            switch(opcao){
                case 1:
                    ordenacaoInsercao();                    
                    break;
                case 2:
                    ordenacaoSelecao();                    
                    break;
                case 3:
                    ordenacaoBolha();
                    break;
                case 4:
                    break;
            }
        }while(opcao != 4);
    }

    //Ordenação por inserção:
    public static void ordenacaoInsercao(){
        ArrayList<Integer> vetorInsercao = new ArrayList<>();
        String verificar;
        int chave;
        int j;
        
        long inicio = System.currentTimeMillis();//Início da contagem.
        
        do{
            int valor = Integer.parseInt
            (JOptionPane.showInputDialog(null,
            "Insira um valor: "));
            vetorInsercao.add(valor);
            verificar = JOptionPane.showInputDialog
            (null, "Inserir mais um valor?" + "\nSIM (Digite: 1)."
                                                        + "\nNÃO (Digite: 2).");
        }while(verificar.equals("1"));
        
        /*Início do algoritmo;
        
        Inserção: Determina o segundo (1) elemento como sendo o menor e o arma-
        zena em uma variável. Depois compara ele com o elemento na posição ante-
        rior.
        */
        for (int i = 1; i < vetorInsercao.size(); i++) {
            /*Define quem está na segunda posição como a chave, considerada
            a princípio a posição com o menor valor.*/
            chave = vetorInsercao.get(i);
            
            /*Inicia o segundo loop uma posição antes da chave (que é i), logo
            a posição será j = i-1.
            
            O loop vai ocorrer enquanto o índice for menor ou igual a zero E o 
            elemento na posição J for maior que a chave.
            */
            for (j = i-1; (j>=0 && vetorInsercao.get(j) > chave); j--){
                /*Se o loop encontrar um elemento menor do que a chave, ele irá
                parar.
                
                Se o loop encontrar um elemento maior do que a chave, ele irá
                deslocar esse elemento uma posição acima, para a direita.
                
                J+1 é a posição onde o elemento será inserido.
                J é a posição atual do elemento a ser inserido em J+1*/
                vetorInsercao.set(j + 1, vetorInsercao.get(j));                            
            }
            /*Determina a chave como sendo J+1*/
            vetorInsercao.set(j + 1, chave); 
        }
        long fim = System.currentTimeMillis();//Fim da contagem.
        long tempoExecucao = fim - inicio;
        
        JOptionPane.showMessageDialog(null, vetorInsercao);
        JOptionPane.showMessageDialog(null, "Tempo de execução:"
                                                            + tempoExecucao);
    }
    
    
    //Ordenação por seleção:
    public static void ordenacaoSelecao(){
        ArrayList<Integer> vetorSelecao = new ArrayList<>();
        String verificar;
        
        long inicio = System.currentTimeMillis();//Início da contagem.
        
        do{
        int valor = Integer.parseInt
        (JOptionPane.showInputDialog(null, 
        "Insira um valor: "));
        vetorSelecao.add(valor);
        verificar = JOptionPane.showInputDialog
        (null, "Inserir mais um valor?"
                         + "\nSIM (Digite: 1)."
                         + "\nNÃO (Digite: 2).");
        }while(verificar.equals("1"));            
            
        /*Início do algoritmo;
        
        Seleção: determina o elemento da primeira posição (0) como sendo o menor
        e o guarda em uma variável temporariamente.
        
        */
        for (int i = 0; i < vetorSelecao.size(); i++) {
            int posicaoMenor = i;
               
            /*
            O segundo laço começa uma posição à frente do primeiro.
            */
            for (int j = i+1; j < vetorSelecao.size(); j++) {
                /*
                Se o elemento à frente da menorPosição for menor, há troca.
                */
                if(vetorSelecao.get(j) < vetorSelecao.get(posicaoMenor)){
                    /*
                    Essa troca consiste em depositar esse novo elemento, na 
                    variável que armazena o menor valor.
                    */
                    posicaoMenor = j;
                }
                
                /*
                Agora J, passa a ser a posicaoMenor.
                
                Se posicaoMenor (j) for diferente de I, significa que precisamos
                atualizar o I para que agora ele tenha o valor da posicaoMenor.
                */
            }
            if(posicaoMenor != i){
                /*
                ...set(posição , elemento)...;
                
                Armazenar I numa variável auxiliar.
                Posição I irá ficar vazia.
                */
                int aux = vetorSelecao.get(i);
                
                /*
                Depositar a posicaoMenor no I.
                posicaoMenor irá ficar vazia.
                */
                vetorSelecao.set(i, vetorSelecao.get(posicaoMenor));
                
                /*
                Depositar a auxiliar na menorPosicao.
                */
                vetorSelecao.set(posicaoMenor, aux);       
            }
        }
        long fim = System.currentTimeMillis();//Fim da contagem.
        long tempoExecucao = fim - inicio;

        
        JOptionPane.showMessageDialog(null, vetorSelecao);
        JOptionPane.showMessageDialog(null, "Tempo de execução:"
                                                           + tempoExecucao);        
    }
    
    
    //Ordenação bolha:
    public static void ordenacaoBolha(){
        ArrayList<Integer> vetorBolha = new ArrayList<>();
        String verificar;
        boolean houveTroca = true;
        
        long inicio = System.currentTimeMillis();//Início da contagem.
        
        do{
            int valor = Integer.parseInt
            (JOptionPane.showInputDialog(null, 
            "Insira um valor: "));
            vetorBolha.add(valor);
            verificar = JOptionPane.showInputDialog
            (null, "Inserir mais um valor?"
                             + "\nSIM (Digite: 1)."
                             + "\nNÃO (Digite: 2).");
        }while(verificar.equals("1"));
         
        /*Início do algoritmo.
        
        Bolha: compara os números lado a lado.
        Ex: primeira posição e segunda posição, segunda posição e terceira...
        
        Enquanto houver troca, o algoritmo será executado*/
        while(houveTroca){
            /*
            Inicialmente ele é falso para que o algoritmo não se repita
            infinitamente.
            */
            houveTroca = false;
            
            /*
            Vai executar o for até a penúltima posição, isso porque no primeiro
            loop, o maior valor já será levado até o final
            */
            for (int i = 0; i < vetorBolha.size() - 1; i++) {
                /*
                Se o vetor na posição 0 for maior que o vetor na posição 1 
                (a frente)
                */
                if(vetorBolha.get(i) > vetorBolha.get(i + 1)){
                    /*
                    Armazenar o primeiro elemento na variável auxiliar.
                    A posição ficará vazia.
                    */
                    int aux = vetorBolha.get(i);
                    
                    /*
                    Tirar o segundo elemento da posição dele e depositar na 
                    primeira posição.
                    A segunda posição ficara vazia.
                    */
                    vetorBolha.set(i, vetorBolha.get(i+1));
                    
                    /*Depositar a variável auxiliar na segunda posição, que 
                    antes estava vazia*/
                    vetorBolha.set(i+1, aux);
                    
                    /*Garantia de que ao identificar uma troca, o algoritmo 
                    continue até que não hajam mais*/
                    houveTroca = true;
                }
            }
        }
        
        long fim = System.currentTimeMillis();//Fim da contagem.
        long tempoExecucao = fim - inicio;

        JOptionPane.showMessageDialog(null, vetorBolha);
        JOptionPane.showMessageDialog(null, "Tempo de execução:"
                                                           + tempoExecucao);
    }
}
