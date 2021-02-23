package edu.prahlad.java.course2.oop.solidPrinciples.interfaceSegregation.before;

/**
 * All methods can be implemented
 */
public class Amazon implements CloudProvider{
    @Override
    public void storeFile(String name) {

    }

    @Override
    public void getFile(String name) {

    }

    @Override
    public void createServer(String region) {

    }

    @Override
    public void listServer(String region) {

    }

    @Override
    public void getCDNAddress() {

    }
}
