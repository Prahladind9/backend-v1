package leetcode.learn.DataStructures.Recursion;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        for(String s: permutations("es")){
            System.out.println(">>> " + s);
        }
    }

    public static ArrayList<String> permutations(String word){
        ArrayList<String> result = new ArrayList<>();

        //The empty string has a single permutation: itself
        if(word.length() ==0){
            result.add(word);
            return result;
        }else {
            //Loop through all character positions
            for(int i=0; i < word.length(); i++){
                //Form a shorter word by removing the ith character
                String shorter = word.substring(0,i) + word.substring(i+1);

                //Generate all permutations of the simpler word
                ArrayList<String> shorterPermutations  = permutations(shorter);

                //Add the removed character to the front of
                // each permutation of the simpler word
                for(String s: shorterPermutations){
                    result.add(word.charAt(i) +s);
                }
            }

            //Return all permutations
            return result;
        }
    }

    public static ArrayList<String> permutationsTest(String word){
        ArrayList<String> result = new ArrayList<>();

        //The empty string has a single permutation: itself
        if(word.length() ==0){
            result.add(word);
            return result;
        }else {
            //Loop through all character positions
            for(int i=0; i < word.length(); i++){
                //Form a shorter word by removing the ith character
                String shorter = word.substring(0,i) + word.substring(i+1);
                /*System.out.println(" word.charAt(i) > " + word.charAt(i));
                System.out.println(" word.substring(0,i) > " + word.substring(0,i));
                System.out.println(" word.substring(i+1) > " + word.substring(i+1));
                */System.out.println(" i > " + i + " > Shorter > " + shorter);

                //Generate all permutations of the simpler word
                ArrayList<String> shorterPermutations  = permutations(shorter);

                //Add the removed character to the front of
                // each permutation of the simpler word
                for(String s: shorterPermutations){
                    System.out.println(" i > " + i + " > Shorter > " + shorter + " string > " +s);
                    System.out.println(" word.charAt(i) +s > " + word.charAt(i) +s);
                    result.add(word.charAt(i) +s);
                }
            }

            //Return all permutations
            return result;
        }
    }
}
