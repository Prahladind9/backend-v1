package edu.prahlad.udemy.bigO;

public class AddupTo {
    public static void main(String[] args) {
        System.out.println(addUptoApproach1(200));
        System.out.println(addUptoApproach1(200));
    }

    private static int addUptoApproach1(int numberUpto){
        //1.2 sec
        //O(n)
        int total = 0;
        for (int i = 0; i < numberUpto; i++) {
            total=+ i;
        }

        return total;
    }


    private static int addUptoApproach2(int n){
        //0.000001 sec
        //O(1)
        final int total = (n *(n + 1))/2;
        return total;
    }
}
