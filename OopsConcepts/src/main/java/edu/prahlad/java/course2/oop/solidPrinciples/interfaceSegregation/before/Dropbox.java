package edu.prahlad.java.course2.oop.solidPrinciples.interfaceSegregation.before;

public class Dropbox implements CloudProvider{
    @Override
    public void storeFile(String name) {

    }

    @Override
    public void getFile(String name) {

    }

    @Override
    public void createServer(String region) {
        //Not Implemented
    }

    @Override
    public void listServer(String region) {
        //Not Implemented
    }

    @Override
    public void getCDNAddress() {
        //Not Implemented
    }
}
