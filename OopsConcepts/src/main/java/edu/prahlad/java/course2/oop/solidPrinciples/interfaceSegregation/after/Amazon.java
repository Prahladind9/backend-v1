package edu.prahlad.java.course2.oop.solidPrinciples.interfaceSegregation.after;

/**
 * All methods can be implemented
 */
public class Amazon implements CDNProvider, CloudHostingProvider, CloudStorageProvider{
    @Override
    public void getCDNAddress() {

    }

    @Override
    public void createServer(String region) {

    }

    @Override
    public void listServers(String region) {

    }

    @Override
    public void storeFile(String name) {

    }

    @Override
    public void getFile(String name) {

    }
}
