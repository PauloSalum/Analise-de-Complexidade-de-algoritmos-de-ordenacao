package ManipulacaoArquivos;

/**
 * Created by psalum on 03/06/2015.
 */
public class Lista {

    public static void criarLista(int quantidade, String caminho){
        int[]arraydenumeros = new int[quantidade];
        for (int i = quantidade; i>0; i--){
            arraydenumeros[quantidade-i]=i;
        }
        Arquivo a = new Arquivo();
        a.GerarArquivo(caminho+String.valueOf(quantidade),arraydenumeros);
    }
}
