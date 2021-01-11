package edu.prahlad.java.oops2.abstraction;

// Abstarct Book Class
abstract class Book {

    // Protected Fields
    protected String name;
    protected String author;
    protected String price;

    // Parameterized Constructor
    public Book(String name, String author, String price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Abstract Method
    public abstract String getDetails();

    public String getTs(){
        return "";
    };

}

// Class MyBook extending Book Class
class MyBook extends Book {

    // Parameterized Constructor
    public MyBook(String name, String author, String price) {
        super(name, author, price);
    }

    // Overrideing the getDetails Abstrat Method of the Base Class
    public String getDetails() {
        // Write your code here
        System.out.println(super.name + ", " + super.author + ", " + price);
        return super.name + ", " + super.author + ", " + price;
    }

    public static void main(String[] args) {
        Book myBook = new MyBook("Harry Potter", "J.k. Rowling", "100");
        myBook.getDetails();
        myBook.getTs();
    }

}
