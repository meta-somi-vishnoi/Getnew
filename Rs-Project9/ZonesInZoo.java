package ZooManagementSystem;

import java.util.*;

class ZonesInZoo {
    private String zoneName;
    private String zoneType;
    private int hasCanteen;
    private int hasPark;
    private int totalCages;
    private int spareCapacity;

    ZonesInZoo(String zoneName, String zoneType, int totalCages) {
        this.zoneName = zoneName;
        this.zoneType = zoneType;
        this.totalCages = totalCages;
        spareCapacity = totalCages;
    }

    public void setCanteen(int hasCanteen) {
        this.hasCanteen = hasCanteen;
    }

    public void setPark(int hasPark) {
        this.hasPark = hasPark;
    }

    public int getSpareCapacity() {
        return spareCapacity;
    }

    public void setSpareCapacity(int quantity) {
        spareCapacity = totalCages - quantity;
        totalCages -= quantity;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getZoneType() {
        return zoneType;
    }
    
    public void getInformationOfZone() {
        System.out.println("The Zone name is: " + zoneName);
        System.out.println("Zone has canteen: " + hasCanteen);
        System.out.println("Zone has park: " + hasPark);
        System.out.println("Zone has number of cages: " + totalCages);
    }
}

class MammalZone extends ZonesInZoo {
    MammalZone(String zoneName, String zoneType, int totalCages) {
        super(zoneName, zoneType, totalCages);
    }
}

class ReptileZone extends ZonesInZoo {
    ReptileZone(String zoneName, String zoneType, int totalCages) {
        super(zoneName, zoneType, totalCages);
    }
}

class BirdZone extends ZonesInZoo {
    BirdZone(String zoneName, String zoneType, int totalCages) {
        super(zoneName, zoneType, totalCages);
    }
}