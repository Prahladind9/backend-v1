package leetcode.learn.DataStructures.ArraysAndString.String;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(" 0 - 0 ");
        System.out.println('0' -'0');

        System.out.println(" 1 - 0 ");
        System.out.println('1' -'0');

        System.out.println(" 0 - 1 ");
        System.out.println('0' -'1');

        System.out.println(" 1 + 1 ");
        System.out.println('1' + '1');

        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("10", "11");
    }

    public String addBinary(String a, String b) {
        String sum = "";
        int s = 0;

        for(int i = a.length() -1, j = b.length()-1; i >= 0 || j >= 0 || s == 1; i--, j--){

            s = s + ((i >= 0) ? a.charAt(i) -'0': 0);
            s = s + ((j >= 0) ? b.charAt(j) -'0': 0);

            sum  = (char) (s%2 + '0') + sum;
            s /=2;
        }

        System.out.println(sum);
        return sum;
    }

    public String addBinary2(String a, String b) {

        String sum = "";

        int s = 0;

        for(int i = a.length() -1, j = b.length()-1; i >= 0 || j >= 0 || s == 1; i--, j--){

            System.out.println("s val " + s);

            System.out.println("i val " + i);
            System.out.println("a.charAt(i) " + a.charAt(i));

            System.out.println("j val " + j);
            System.out.println("b.charAt(j) " + b.charAt(j));
            System.out.println(a.charAt(i)-'0');
            s = s + ((i >= 0) ? a.charAt(i) -'0': 0);
            System.out.println("s val after a  " + s);
            s = s + ((j >= 0) ? b.charAt(j) -'0': 0);
            System.out.println("s val after b  " + s);

            sum  = (char) (s%2 + '0') + sum;

            s /=2;
        }

        System.out.println(sum);
        return sum;
    }
}
