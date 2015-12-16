package Algoritmos;

import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;
import ManipulacaoArquivos.Lista;
import models.alg;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class InsertionSort implements IAlgoritmo {
//
//    public void run(){
//
//        Arquivo a = new Arquivo();
//        String caminho = "Lista/InsertionSort/";
//        a.GerarDiretorio("InsertionSort");
//        Lista.criarLista(1000000, caminho);
//        Lista.criarLista(100000,caminho);
//        Lista.criarLista(10000,caminho);
//        Lista.criarLista(1000,caminho);
//        Lista.criarLista(100,caminho);
//
//        System.out.println("inicio do InsertionSort");
//        alg insertion = new alg();
//        insertion.setNome("InsertionSort");
//        insertion.setTempo(inicio());
//        StaticList.addAlgoritmos(insertion);
//        System.out.println("Fim do InsertionSort");
//    }

    public float[] inicio(){
        Arquivo a  = new Arquivo();
        long[] qtnumeros ={100,1000, 10000,100000, 1000000};
        float[] tempo = new float[qtnumeros.length];

        for(int i =0; i< qtnumeros.length; i++){
            try{
                tempo[i]=calcularTempoDeExecucao(a.LerArquivo("Lista/Desordenadas/"+String.valueOf(qtnumeros[i])));
            }catch(Exception e){
                System.out.println("e = " + e);
            }
        }

        Graficos g = new Graficos();
        g.GerarGraficos("InsertionSort",tempo,qtnumeros);
        return tempo;
    }

    @Override
    public float calcularTempoDeExecucao(int[] listaNumeros) {

        int i, j, eleito;

        long TempoInicio = System.nanoTime();
        System.out.println("Iniciou Insertion Lista: " + listaNumeros.length);

        for (i = 1; i < listaNumeros.length; i++) {
            eleito = listaNumeros[i];
            j = i;
            while ((j > 0) && (listaNumeros[j -1] > eleito)) {
                listaNumeros[j] = listaNumeros[j -1];
                j = j - 1;
            }
            listaNumeros[j] = eleito;
        }

        long TempoFinal= System.nanoTime();

//        Arquivo a = new Arquivo();
//        a.GerarDiretorio("Insertion");
//        a.GerarArquivo(String.valueOf("Ordenados/Insertion/" + listaNumeros.length) + " Insertion Ordenada", listaNumeros);
        return (float)(TempoFinal-TempoInicio)/1000000000;    }
}
