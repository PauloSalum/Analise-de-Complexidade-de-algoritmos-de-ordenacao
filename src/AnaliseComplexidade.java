import Algoritmos.*;
import Funcoes.Funcao;
import ManipulacaoArquivos.Arquivo;
import ManipulacaoArquivos.Graficos;
import ManipulacaoArquivos.Lista;
import models.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class AnaliseComplexidade {

    private long tempInicial;

    public static void main(String[] args) {

        Funcao f = new Funcao();
        f.NaoQuadrado();
        f.nlog2n();
        f.nlogn();

        Graficos g = new Graficos();

        System.out.println("Iniciando Criar Listas");
        Arquivo a = new Arquivo();
        String caminho = "Lista/Desordenadas/";
        a.GerarDiretorio("Desordenadas");
        Lista.criarLista(1000000, caminho);
        Lista.criarLista(100000,caminho);
        Lista.criarLista(10000,caminho);
        Lista.criarLista(1000,caminho);
        Lista.criarLista(100,caminho);
        System.out.println("Listas Criadas!!");

        System.out.println("inicio do QuickSort");
        alg quick = new alg();
        quick.setNome("QuickSort");
        quick.setTempo(new QuickSort().inicio());
        StaticList.addAlgoritmos(quick);
        System.out.println("Fim do QuickSort");

        System.out.println("inicio do MergeSort");
        alg merge = new alg();
        merge.setNome("MergeSort");
        merge.setTempo(new MergeSort().inicio());
        StaticList.addAlgoritmos(merge);
        System.out.println("Fim do MergeSort");

        System.out.println("inicio do HeapSort");
        alg heap = new alg();
        heap.setNome("HeapSort");
        heap.setTempo(new HeapSort().inicio());
        StaticList.addAlgoritmos(heap);
        System.out.println("Fim do HeapSort");

        System.out.println("inicio do SelectSort");
        alg select = new alg();
        select.setNome("SelectSort");
        select.setTempo(new SelectSort().Inicio());
        StaticList.addAlgoritmos(select);
        System.out.println("Fim do SelectSort");

        System.out.println("inicio do InsertionSort");
        alg insertion = new alg();
        insertion.setNome("InsertionSort");
        insertion.setTempo(new InsertionSort().inicio());
        StaticList.addAlgoritmos(insertion);
        System.out.println("Fim do InsertionSort");

        System.out.println("inicio do BubbleSort");
        alg bubble = new alg();
        bubble.setNome("BubbleSort");
        bubble.setTempo(new BubbleSort().inicio());
        StaticList.addAlgoritmos(bubble);
        System.out.println("fim do BubbleSort");

        g.GerarGraficos(StaticList.getAlgoritmos(), "Etapa1");
        StaticList.AlgoritmoClean();

    }

    public final static void clearConsole()
    {
        try
        {
            final String operatingSystem = System.getProperty("os.name");

            if (operatingSystem .contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {

        }
    }
}
