package edu.prahlad.java.course2.oop.solidPrinciples.dependencyInversion.before;

import java.time.LocalDate;

/**
 * Before: a high-level class depends on a low-level class
 */
public class BudgetReport {
    public MySQLDatabase database;
    public void open(LocalDate localDate){}
    public void save(){};
}
