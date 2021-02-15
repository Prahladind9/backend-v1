package edu.prahlad.java.course1.oops2.abstraction;

public abstract class AbstractRecipe {

    //is a relationship
    public void execute(){
        getReady();
        doTheDish();
        cleanup();
    }

    protected abstract void getReady();
    protected abstract void doTheDish();
    protected abstract void cleanup();

}
