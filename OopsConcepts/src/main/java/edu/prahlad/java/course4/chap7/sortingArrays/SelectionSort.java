package edu.prahlad.java.course4.chap7.sortingArrays;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        double[] list = {1, 9, 4.5, 6.6, 5.7,-4.6, -10, 99, 134, -456};
        Arrays.stream(selectionSort(list)).forEach(System.out::println);

    }

    public static double[] selectionSort(double[] list){
        for (int i = 0; i < list.length; i++) {
            //select the smallest element in list[i ... list.length -1]
            //Swap the smallest with list[i], if necessary

            //Step1 - find the minimum in the list[i .. list.length -1]
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if(currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            //Step2 - swap list[i] with list[currentMinIndex] if necessary
            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }

        return list;
    }
}
