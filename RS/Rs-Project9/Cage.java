package ZooManagementSystem;

import java.util.*;

public class Cage {
    private static int cageId = 0;
    String typeOfAnimal;
    int quantity;
    String zoneId;
    int totalCapacity;
    private int spareCapacity;

    public Cage(String typeOfAnimal, int quantity, int totalCapacity) {
        this.typeOfAnimal = typeOfAnimal;
        this.quantity = quantity;
        this.totalCapacity = totalCapacity;
        spareCapacity = totalCapacity;
        zoneId = null;
        cageId++;
    }

    public void setZoneId(String id) {
        zoneId = id;
    }

    public String getZoneId() {
        return zoneId;
    }

    public int getCageId() {
        return cageId;
    }

    public void getInformationOfCage() {
        System.out.println("The id of cage is :" + cageId);
        System.out.println("The cage is in zone:" + zoneId);
        System.out.println("The cage contains: " + typeOfAnimal);
        System.out.println("The total number of cages are " + quantity);
        System.out.println("The total capacity of a cage is " + totalCapacity);
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public int getCageQuantity() {
        return quantity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setCageQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCageSpareCapacity() {
        return spareCapacity;
    }

    public void setCageSpareCapacity(int capacity) {
        spareCapacity = capacity;
    }

    public String getNameOfAnimalInCage() {
        return typeOfAnimal;
    }
}