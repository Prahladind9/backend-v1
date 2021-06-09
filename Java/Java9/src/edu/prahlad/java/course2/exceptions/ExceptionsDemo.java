package edu.prahlad.java.course2.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {

    public static void throwNullPointer() {
        try {
            sayHello(null);
        } catch (NullPointerException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Finally block");
        }

    }

    public static void handleShowFile() {
        try (var reader = new FileReader("file.txt");
             var writer = new FileWriter("...");
        ) {
            var value = reader.read();
        } catch (IOException e) {
            System.out.println("Could not read data.");
        }
    }

    public static void showFile() {
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
            new SimpleDateFormat().parse("");
            System.out.println("File opened");
        } /*catch (FileNotFoundException ex) {
            System.out.println("File does not exist.");
        }*/ catch (IOException | ParseException e) {
            System.out.println("Could not read data.");
        } /*catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }
}
