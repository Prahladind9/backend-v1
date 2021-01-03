package edu.prahlad.java.oops2.abstraction;

public class Recipe1 extends AbstractRecipe{
    @Override
    protected void getReady() {
        System.out.println("Get the raw materials");
        System.out.println("Get the utensils");
    }

    @Override
    protected void doTheDish() {
        System.out.println("do the dish");
    }

    @Override
    protected void cleanup() {
        System.out.println("clean the dishes");
    }
}
