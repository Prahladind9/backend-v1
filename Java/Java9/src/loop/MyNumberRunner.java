package loop;

public class MyNumberRunner {

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber(9);
        boolean isPrime = myNumber.isPrime();

        int sumUptoN = myNumber.sumUptoN();
        int sumOfDivisors = myNumber.sumOfDivisors();
        myNumber.printANumberTriangle();

        System.out.println("isPrime " + isPrime);
        System.out.println("sumUptoN " + sumUptoN);
        System.out.println("sumOfDivisors " + sumOfDivisors);
    }
}
