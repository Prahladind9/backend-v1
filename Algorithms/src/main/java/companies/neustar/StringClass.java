package companies.neustar;

public class StringClass {

    public static void main(String []args){
        String myStr = "AccountName Details account:'FinFlowz'& Charges Applicable are charge:'1'  'USD'  Please press '1' for confirmation' and '2' to cancel the transaction ";
        System.out.println(myStr.lastIndexOf("charge:'"));
        System.out.println(myStr.lastIndexOf("charge:'", 64));
        System.out.println(myStr.lastIndexOf("charge:'") + "charge:'".length());
        System.out.println(myStr.indexOf("'", 71));
        System.out.println(myStr.substring(71, 72));
        System.out.println(myStr.endsWith("charge:'"));
    }
}
