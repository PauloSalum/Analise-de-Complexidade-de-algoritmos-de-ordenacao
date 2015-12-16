package Algoritmos;

import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;
import ManipulacaoArquivos.Lista;
import models.alg;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class BubbleSort implements IAlgoritmo {

//    public void run(){
//        Arquivo a = new Arquivo();
//        String caminho = "Lista/BubbleSort/";
//        a.GerarDiretorio("BubbleSort");
//        Lista.criarLista(1000000,caminho);
//        Lista.criarLista(100000,caminho);
//        Lista.criarLista(10000,caminho);
//        Lista.criarLista(1000,caminho);
//        Lista.criarLista(100,caminho);
//
//        System.out.println("inicio do BubbleSort");
//        alg bubble = new alg();
//        bubble.setNome("BubbleSort");
//        bubble.setTempo(inicio());
//        StaticList.addAlgoritmos(bubble);
//        System.out.println("fim do BubbleSort");
//
//    }

    public float[] inicio(){
        Arquivo a  = new Arquivo();
        long[] qtnumeros ={100,1000, 10000, 100000, 1000000};
        float[] tempo = new float[qtnumeros.length];

        for(int i =0; i< qtnumeros.length; i++){
            try{
                tempo[i]=calcularTempoDeExecucao(a.LerArquivo("Lista/Desordenadas/"+String.valueOf(qtnumeros[i])));
            }catch(Exception e){
                System.out.println("e = " + e);
            }
        }
        Graficos g = new Graficos();
        g.GerarGraficos("BubbleSort",tempo,qtnumeros);
        return tempo;
    }

    @Override
    public float calcularTempoDeExecucao(int[] listaNumeros) {
        int temp = 0;
        long TempoInicio = System.nanoTime();
        System.out.println("Iniciou Bubble Lista: " + listaNumeros.length);
        for(int i =0; i<listaNumeros.length;i++){
            for(int j=0; j <listaNumeros.length-1;j++){
                if (listaNumeros[j] > listaNumeros[j + 1]) {
                    temp = listaNumeros[j + 1];
                    listaNumeros[j + 1] = listaNumeros[j];
                    listaNumeros[j] = temp;
                }
            }
        }
        long TempoFinal= System.nanoTime();

//        Arquivo a = new Arquivo();
//        a.GerarDiretorio("Bubble");
//        a.GerarArquivo("Ordenados/Bubble/" + String.valueOf(listaNumeros.length) + " Bubble Ordenada", listaNumeros);
        return (float)(TempoFinal-TempoInicio)/1000000000;
    }
}
