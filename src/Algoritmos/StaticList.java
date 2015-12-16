package Algoritmos;

import models.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PauloMagno on 13/06/2015.
 */
public class StaticList {

   private static List<alg> algoritmos = new ArrayList<>();

    public static List<alg> getAlgoritmos() {
        return algoritmos;
    }

    public static void addAlgoritmos(alg algoritmos) {
        StaticList.algoritmos.add(algoritmos);;
    }

    public static void AlgoritmoClean(){
        algoritmos.clear();
    }
}
