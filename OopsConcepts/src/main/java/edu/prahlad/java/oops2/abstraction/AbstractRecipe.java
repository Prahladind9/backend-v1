package edu.prahlad.java.oops2.abstraction;

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
