package edu.prahlad.java.course1.oops2.abstraction;

public class RecipeWithMicrowave extends AbstractRecipe{
    @Override
    protected void getReady() {
        System.out.println("Get the raw materials");
        System.out.println("Get the Micorwave");
    }

    @Override
    protected void doTheDish() {
        System.out.println("do the dish");
    }

    @Override
    protected void cleanup() {
        System.out.println("clean the dishes & swith off microwave");
    }
}
