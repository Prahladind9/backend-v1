package edu.prahlad.udemy.recursion;

public class R_1 {
    public static final void countDown(int num){
        //Exiting Soln
        if(num <=0) {
            System.out.println("All done!");
            return;
        }
        System.out.println(num);
        num--;
        countDown(num);
    }

    public static void main(String[] args) {
        countDown(10);
    }
}
