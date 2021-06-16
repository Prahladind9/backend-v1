package edu.prahlad.java.course3.generics.lsv;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();
        build(building);
        build(office);

        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Office());
        buildings.add(new Building());
        build(buildings);

    }

    static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }

    static void build(List<Building> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(i+1 + ": " + buildings.get(i).toString());
        }
    }
}
