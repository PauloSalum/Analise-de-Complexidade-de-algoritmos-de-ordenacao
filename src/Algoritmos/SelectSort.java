package Algoritmos;

import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;
import ManipulacaoArquivos.Lista;
import models.alg;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class SelectSort implements IAlgoritmo {

//    public void run(){
//
//        Arquivo a = new Arquivo();
//        String caminho = "Lista/";
//        a.GerarDiretorio("Desordenadas");
//        Lista.criarLista(1000000, caminho);
//        Lista.criarLista(100000,caminho);
//        Lista.criarLista(10000,caminho);
//        Lista.criarLista(1000,caminho);
//        Lista.criarLista(100,caminho);
//
//        System.out.println("inicio do SelectSort");
//        alg select = new alg();
//        select.setNome("SelectSort");
//        select.setTempo(inicio());
//        StaticList.addAlgoritmos(select);
//        System.out.println("Fim do SelectSort");
//    }

    public float[] Inicio(){
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
        g.GerarGraficos("SelectSort",tempo,qtnumeros);
        return tempo;
    }
    @Override
    public float calcularTempoDeExecucao(int[] listaNumeros) {
        int min, aux;
        long TempoInicio = System.nanoTime();
        System.out.println("Iniciou Select Lista: " + listaNumeros.length);

        for (int i = 0; i < listaNumeros.length - 1; i++)
        {
            min = i;

            for (int j = i + 1; j < listaNumeros.length; j++)
            {

                if (listaNumeros[j] < listaNumeros[min])
                {
                    min = j;
                }
            }

            if (min != i)
            {
                aux = listaNumeros[min];
                listaNumeros[min] = listaNumeros[i];
                listaNumeros[i] = aux;
            }
        }

        long TempoFinal= System.nanoTime();

//        Arquivo a = new Arquivo();
//        a.GerarDiretorio("Select");
//        a.GerarArquivo("Ordenados/Select/"+String.valueOf(listaNumeros.length)+" Select Ordenada",listaNumeros);
        return (float)(TempoFinal-TempoInicio)/1000000000;

    }
}
