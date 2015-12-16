package Algoritmos;

import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;
import ManipulacaoArquivos.Lista;
import models.alg;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class HeapSort  implements IAlgoritmo {

//    public void run(){
//
//        Arquivo a = new Arquivo();
//        String caminho = "Lista/HeapSort/";
//        a.GerarDiretorio("HeapSort");
//        Lista.criarLista(1000000, caminho);
//        Lista.criarLista(100000,caminho);
//        Lista.criarLista(10000,caminho);
//        Lista.criarLista(1000,caminho);
//        Lista.criarLista(100,caminho);
//
//        System.out.println("inicio do HeapSort");
//        alg heap = new alg();
//        heap.setNome("HeapSort");
//        heap.setTempo(inicio());
//        StaticList.addAlgoritmos(heap);
//        System.out.println("Fim do HeapSort");
//    }

    public float[] inicio(){
        Arquivo a  = new Arquivo();
        long[] qtnumeros ={100,1000, 10000, 100000, 1000000};
        float[] tempo = new float[qtnumeros.length];

        for(int i =0; i< qtnumeros.length; i++){
            try{
                tempo[i]=calcularTempoDeExecucao(a.LerArquivo( "Lista/Desordenadas/"+String.valueOf(qtnumeros[i])));
            }catch(Exception e){
                System.out.println("e = " + e);
            }
        }

        Graficos g = new Graficos();
        g.GerarGraficos("HeapSort",tempo,qtnumeros);
        return tempo;
    }
    @Override
    public float calcularTempoDeExecucao(int[] listaNumeros) {

        long TempoInicio = System.nanoTime();
        System.out.println("Iniciou Heap Lista: " + listaNumeros.length);

        buildMaxHeap(listaNumeros);
        int n = listaNumeros.length;

        for (int i = listaNumeros.length - 1; i > 0; i--)
        {
            swap(listaNumeros, i, 0);
            maxHeapify(listaNumeros, 0, --n);
        }

        long TempoFinal= System.nanoTime();

//        Arquivo a = new Arquivo();
//        a.GerarDiretorio("Heap");
//        a.GerarArquivo("Ordenados/Heap/" + String.valueOf(listaNumeros.length) + " Heap Ordenada", listaNumeros);
        return (float)(TempoFinal-TempoInicio)/1000000000;
    }

    private static void buildMaxHeap(int[] v)
    {
        for (int i = v.length / 2 - 1; i >= 0; i--)
            maxHeapify(v, i, v.length);
    }
    private static void maxHeapify(int[] v, int pos, int n)
    {
        int max = 2 * pos + 1, right = max + 1;
        if (max < n)
        {
            if (right < n && v[max] < v[right])
                max = right;
            if (v[max] > v[pos])
            {
                swap(v, max, pos);
                maxHeapify(v, max, n);
            }
        }
    }

    public static void swap(int[] v, int j, int aposJ)
    {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }

}
