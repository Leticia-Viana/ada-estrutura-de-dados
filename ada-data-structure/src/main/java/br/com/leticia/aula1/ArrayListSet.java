package br.com.leticia.aula1;

import java.util.*;

public class ArrayListSet {

    /** Qual a diferença entre Array, List e Set ? */

    public static void main(String[] args) {

        /** Array
         * É uma lista ordenada
         * Pode-se recuperar valor pelo índice
         * Tem limite de tamanho que devemos estabelecer ao inicializar
         */

        String[] nomesArray = new String[4];
        nomesArray[0] = "Letícia";
        nomesArray[1] = "Michele";
        nomesArray[2] = "Samila";
        nomesArray[3] = "Odair"; // -> Será lançado ArrayIndexOutOfBoundsException, pois supera o tamanho da array.
        System.out.println("Array: " + Arrays.asList(nomesArray));

        /**List
         * É uma lista ordenada
         * Pode-se recuperar valor pelo índice
         * Não tem limite de tamanho
         */

        List<String> nomesList = new ArrayList<>();
        nomesList.add("Letícia");
        nomesList.add("Michele");
        nomesList.add("Samila");
        nomesList.add("Odair");
        System.out.println("List: " + nomesList);

        /**
         * Set
         * É uma lista não-ordenada
         * Não duplica valores
         * Sem limite de tamanho
         */

        Set<String> nomesSet = new HashSet<>();
        nomesSet.add("Letícia");
        nomesSet.add("Michele");
        nomesSet.add("Samila");
        nomesSet.add("Odair");
        nomesSet.add("Odair"); // -> Não vai adicionar novamente na lista
        System.out.println("Set: " + nomesSet);

    }



}
