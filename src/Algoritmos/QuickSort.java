package Algoritmos;

import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class QuickSort implements IAlgoritmo {
    Random random = new Random();
//    public void run(){
//
//        Arquivo a = new Arquivo();
//        String caminho = "Lista/QuickSort/";
//        a.GerarDiretorio("QuickSort");
//        Lista.criarLista(1000000, caminho);
//        Lista.criarLista(100000,caminho);
//        Lista.criarLista(10000,caminho);
//        Lista.criarLista(1000,caminho);
//        Lista.criarLista(100,caminho);
//
//        System.out.println("inicio do QuickSort");
//        alg quick = new alg();
//        quick.setNome("QuickSort");
//        quick.setTempo(inicio());
//        StaticList.addAlgoritmos(quick);
//        System.out.println("Fim do QuickSort");
//    }


    public float[] inicio() {
        Arquivo a = new Arquivo();
        long[] qtnumeros = {100, 1000, 10000, 100000, 1000000};
        float[] tempo = new float[qtnumeros.length];

        for (int i = 0; i < qtnumeros.length; i++) {
            try {
                tempo[i] = calcularTempoDeExecucao(a.LerArquivo("Lista/Desordenadas/" + String.valueOf(qtnumeros[i])));
                //System.out.println(Math.log1p(tempo[i]));
            } catch (Exception e) {
                System.out.println("e = " + e);
            }
        }

        Graficos g = new Graficos();
        g.GerarGraficos("QuickSort", tempo, qtnumeros);

        return tempo;

    }


    @Override
    public float calcularTempoDeExecucao(int[] listaNumeros) {

        long[] listanumeros = new long[listaNumeros.length];
        for (int i = 0; i < listaNumeros.length; i++) {
            listanumeros[i] = listaNumeros[i];
        }
        List<Integer> vetor = new ArrayList<>();
        for (int i = 0; i < listaNumeros.length; i++) {
            vetor.add(listaNumeros[i]);
        }
        long TempoInicio = System.nanoTime();
        System.out.println("Iniciou Quick Lista: " + listaNumeros.length);
        //ordenar(vetor);
        Ordenar(listanumeros, 0, listanumeros.length - 1);
        long TempoFinal = System.nanoTime();

//        Arquivo a = new Arquivo();
//        a.GerarDiretorio("Quick");
//        a.GerarArquivo("Ordenados/Quick/" + String.valueOf(listaNumeros.length) + " Quick Ordenada", listaNumeros);
        return (float) (TempoFinal - TempoInicio) / 1000000000;
    }

    private void Ordenar(long[] vetor, long inicio, long fim) {

        if (inicio < fim) {
            long posicaoPivo = Separar(vetor, inicio, fim);
            Ordenar(vetor, inicio, posicaoPivo - 1);
            Ordenar(vetor, posicaoPivo + 1, fim);
        }
    }

    private long Separar(long[] vetor, long inicio, long fim) {

        long pivo = vetor[random.nextInt(vetor.length)];
        long i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[(int) i] <= pivo)
                i++;
            else if (pivo < vetor[(int) f])
                f--;
            else {
                long troca = vetor[(int) i];
                vetor[(int) i] = vetor[(int) f];
                vetor[(int) f] = troca;
                i++;
                f--;
            }
        }
        vetor[(int) inicio] = vetor[(int) f];
        vetor[(int) f] = pivo;
        return f;
    }
}
