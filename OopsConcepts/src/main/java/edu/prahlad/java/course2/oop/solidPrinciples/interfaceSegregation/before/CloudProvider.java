package edu.prahlad.java.course2.oop.solidPrinciples.interfaceSegregation.before;

/**
 * Before: not all clients can satisfy the requirements
 * of the bloated interface
 */
public interface CloudProvider {

    void storeFile(String name);
    void getFile(String name);
    void createServer(String region);
    void listServer(String region);
    void getCDNAddress();
}
