package ManipulacaoArquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by PauloMagno on 31/05/2015.
 */
public class Arquivo {
    public void GerarDiretorio(String nome) {
        File file = new File("/Lista/");
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        file = new File("./Lista/" + nome + "/");
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    public void GerarArquivo(String nome, int[] lista) {
        try {
            String caminho = "./" + nome + ".txt";
            FileWriter escrita = new FileWriter(caminho);
            BufferedWriter escritor = new BufferedWriter(escrita);
            for (int i : lista) {
                escritor.write(String.valueOf(i));
                escritor.newLine();
            }
            escritor.flush();
            escritor.close();
            escrita.close();


        } catch (Exception e) {
            System.out.println("N�o consegui criar o arquivo, Erro:" + e);
        }
    }

    public int[] LerArquivo(String nome) {
        List<Integer> lista = new ArrayList<>();
        Scanner in = null;

        try {
            File arquivo = new File("./" + nome + ".txt");
            in = new Scanner(arquivo);
            while (in.hasNextLine()) {
                lista.add(Integer.valueOf(in.nextLine()));
            }
            int[] arraydenumeros = new int[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                arraydenumeros[i] = lista.get(i);
            }
            return arraydenumeros;
        } catch (FileNotFoundException e) {
            System.out.println("e = " + e);
            return null;
        }


    }

}
