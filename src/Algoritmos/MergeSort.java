package Algoritmos;

import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;
import ManipulacaoArquivos.Lista;
import models.alg;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class MergeSort implements IAlgoritmo {

//    public void run(){
//
//        Arquivo a = new Arquivo();
//        String caminho = "Lista/MergeSort/";
//        a.GerarDiretorio("MergeSort");
//        Lista.criarLista(1000000, caminho);
//        Lista.criarLista(100000,caminho);
//        Lista.criarLista(10000,caminho);
//        Lista.criarLista(1000,caminho);
//        Lista.criarLista(100,caminho);
//
//        System.out.println("inicio do MergeSort");
//        alg merge = new alg();
//        merge.setNome("MergeSort");
//        merge.setTempo(inicio());
//        StaticList.addAlgoritmos(merge);
//        System.out.println("Fim do MergeSort");
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
        g.GerarGraficos("MergeSort",tempo,qtnumeros);
        return tempo;
    }

    @Override
    public float calcularTempoDeExecucao(int[] listaNumeros) {
        long TempoInicio = System.nanoTime();
        System.out.println("Iniciou Merge Lista: " + listaNumeros.length);

        mergeSort(listaNumeros, 0, listaNumeros.length - 1);
        long TempoFinal = System.nanoTime();

//        Arquivo a = new Arquivo();
//        a.GerarDiretorio("merge");
//        a.GerarArquivo("Ordenados/merge/" + String.valueOf(listaNumeros.length) + " MergeSort Ordenada", listaNumeros);
        return (float)(TempoFinal-TempoInicio)/1000000000;
    }

    public void mergeSort(int[] array, int inicio, int fim) {
        if (fim <= inicio) {
            return;
        }
        int meio = (inicio + fim) / 2;
        mergeSort(array, inicio, meio);
        mergeSort(array, meio + 1, fim);
        int[] A = new int[meio - inicio + 1];
        int[] B = new int[fim - meio];
        for (int i = 0; i <= meio - inicio; i++) {
            A[i] = array[inicio + i];
        }
        for (int i = 0; i <= fim - meio - 1; i++) {
            B[i] = array[meio + 1 + i];
        }
        int i = 0;
        int j = 0;
        for (int k = inicio; k <= fim; k++) {
            if (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    array[k] = A[i++];
                } else {
                    array[k] = B[j++];
                }
            } else if (i < A.length) {
                array[k] = A[i++];
            } else if (j < B.length) {
                array[k] = B[j++];
            }
        }
    }
}
