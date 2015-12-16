package Funcoes;

import ManipulacaoArquivos.Graficos;

import java.util.Map;

/**
 * Created by psalum on 15/06/2015.
 */
public class Funcao {
    Graficos g = new Graficos();
    long qtnumeros[]={100,1000,10000,100000,1000000};

    public void CalcularFuncoes(){





    }

    public void NaoQuadrado(){
        float []resultado = new float[qtnumeros.length];
        for (int i=0;i<qtnumeros.length;i++){
            resultado[i]=qtnumeros[i]*qtnumeros[i];
        }

        g.GerarGraficosfuncoes("N ao Quadrado",resultado,qtnumeros);
    }
    public void nlog2n(){
        float []resultado = new float[qtnumeros.length];
        for (int i=0;i<qtnumeros.length;i++){
            resultado[i]= (float) (qtnumeros[i]* (Math.log(Double.valueOf(qtnumeros[i])/Math.log(2))));
        }
        g.GerarGraficosfuncoes("Nlog2n", resultado, qtnumeros);
    }
    public void nlogn(){
        float []resultado = new float[qtnumeros.length];
        for (int i=0;i<qtnumeros.length;i++){
            resultado[i]= (float) (qtnumeros[i]* Math.log(Double.valueOf(qtnumeros[i])));
        }
        g.GerarGraficosfuncoes("Nlogn", resultado, qtnumeros);

    }

}
