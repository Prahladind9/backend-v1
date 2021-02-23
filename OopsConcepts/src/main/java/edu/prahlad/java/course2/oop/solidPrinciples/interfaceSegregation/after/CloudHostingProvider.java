package edu.prahlad.java.course2.oop.solidPrinciples.interfaceSegregation.after;

/**
 * After: one bloated interface is broken down into a set of more
 * granular interfaces
 */
public interface CloudHostingProvider {
    void createServer(String region);
    void listServers(String region);
}
