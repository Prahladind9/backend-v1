package companies.paypal;

public class SavingAccount {

    public static void main(String[] args) {
        SavingAccount saving = new SavingAccount(1000d, 0.05);
        System.out.println(saving.getInterest(1));
    }

    private Integer noOfTimes = 12;
    //Savings --> Monthly Interest calculation ==> 12

    private Double amount;          //Amount        --> for accurate calculation .. decimal issue with double, non wrapper class
    private Double rate;            //Interest Rate
    // private List<Transaction> transactionList;
    //List of transactions ... Can be looped to get the transaction respective amount
    //Credit Debit Transactions


    public SavingAccount(Double amount, Double rate) {
        this.amount = amount;
        this.rate = rate;
// 		this.transactionList = transactions;

        System.out.println("SavingAccount -> Amount " + amount + " Rate " + rate + " TransactionList ");
    }

    public Double getInterest(Integer duration) {

        //For beter logging used local variables .. knowing that local variables consume memory

        System.out.println("getInterest call with duration -> " + duration);
        Double overallAmount = amount * Math.pow(1 + (rate/noOfTimes), noOfTimes * duration);
        System.out.println("Calculated Overall Amount " + overallAmount);
        Double compountInterest = overallAmount - amount;
        System.out.println("CompountInterest Calculated - " + compountInterest);
        return compountInterest;

    }

}
