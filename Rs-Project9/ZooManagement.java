package ZooManagementSystem;

import java.util.*;

public class ZooManagement {
    public static void main(String[] args) {
        int option;
        String zoneName;
        String animalName;
        int index;
        int flag;
        int cageId;
        ZooLists zooList = new ZooLists();
        Scanner sc = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        System.out.println("Zoo Management System");
        do {
            System.out.println("Choose option:");
            System.out.println("1. To add zone to zoo");
            System.out.println("2. To add cages to zone");
            System.out.println("3. To add animal to zoo");
            System.out.println("4. To add animal to cage");
            System.out.println("5. To remove animal from cage");
            System.out.println("6. To print animal information");
            System.out.println("7. To print cage information");
            System.out.println("8. To print zone information");
            System.out.println("9. To print animals in given cage");
            System.out.println("10. To print animals in given zone");
            option = sc.nextInt();
            switch (option) {
            case 1:
                System.out.println("Choose Option:");
                System.out.println("1. To add mammal zone to zoo");
                System.out.println("2. To add bird zone to zoo");
                System.out.println("3. To add reptile zone to zoo");
                int choice = sc.nextInt();
                System.out.println("Enter name of zone");
                zoneName = string.next();
                for (int i = 0; i < zooList.listOfZonesInZoo.size(); i++) {
                    if (zooList.listOfZonesInZoo.get(i).getZoneName().equals(zoneName)) {
                        System.out.println("Animal already exist");
                        System.exit(0);
                    }
                }
                System.out.println("Enter maximum number of cages in zone");
                int totalCages = sc.nextInt();
                System.out.println("No of canteen zone has");
                int canteen = sc.nextInt();
                System.out.println("No of park zone has");
                int park = sc.nextInt();
                ZonesInZoo zones;
                if (choice == 1) {
                    zones = new MammalZone(zoneName, "Mammal", totalCages);
                    zooList.listOfZonesInZoo.add(zones);
                    zones.setCanteen(canteen);
                    zones.setPark(park);
                    System.out.println("Zone added successfully");
                } else if (choice == 2) {
                    zones = new BirdZone(zoneName, "Bird", totalCages);
                    zooList.listOfZonesInZoo.add(zones);
                    zones.setCanteen(canteen);
                    zones.setPark(park);
                    System.out.println("Zone added successfully");
                } else if (choice == 3) {
                    zones = new ReptileZone(zoneName, "Reptile", totalCages);
                    zooList.listOfZonesInZoo.add(zones);
                    zones.setCanteen(canteen);
                    zones.setPark(park);
                    System.out.println("Zone added successfully");
                } else {
                    System.out.println("Wrong choice entered");
                }
                break;
            case 2:
                System.out.println("Enter Zone name to add cages");
                zoneName = string.next();
                for (index = 0; index < zooList.listOfZonesInZoo.size(); index++) {
                    if (zooList.listOfZonesInZoo.get(index).getZoneName().equals(zoneName)) {
                        System.out.println("Enter animal for which cage is required");
                        String animalType = string.next();
                        for (AnimalEnum enumValue : AnimalEnum.values()) {
                            if (zooList.listOfZonesInZoo.get(index).getZoneType().equals(enumValue.getCategory())
                                    && animalType.equals(enumValue.getName())) {
                                System.out.println("Enter quantity of cages required");
                                int quantity = sc.nextInt();
                                System.out.println("Enter capacity of each cage");
                                int capacity = sc.nextInt();
                                if (zooList.listOfZonesInZoo.get(index).getSpareCapacity() >= quantity) {
                                    Cage cage = new Cage(animalType, quantity, capacity);
                                    cage.setZoneId(zoneName);
                                    zooList.cagesList.add(cage);
                                    zooList.listOfZonesInZoo.get(index).setSpareCapacity(quantity);
                                    System.out.println("Cage added successfully");
                                    break;
                                } else {
                                    System.out.println("Cages exceed zone limit");
                                    System.exit(0);
                                }
                            } else {
                                System.out.println("Animal Category is not same as zone category");
                                System.exit(0);
                            }
                        }
                    }
                }
                break;
            case 3:
                System.out.println("1. To add Lion to zoo");
                System.out.println("2. To add Snake to zoo");
                System.out.println("3. To add Pigeon to zoo");
                int chooseAnimal = sc.nextInt();
                System.out.println("Enter animal name to add to Zoo");
                animalName = string.next();
                for (int i = 0; i < zooList.animalsList.size(); i++) {
                    if (zooList.animalsList.get(i).getName().equals(animalName)) {
                        System.out.println("Animal already exist");
                        System.exit(0);
                    }
                }
                System.out.println("Enter age of animal");
                int age = sc.nextInt();
                System.out.println("Enter weight of animal");
                int weight = sc.nextInt();
                System.out.println("Enter number Of legs of animal");
                int numberOfLegs = sc.nextInt();
                System.out.println("Enter language of animal");
                String language = string.next();
                Animal animal;
                switch (chooseAnimal) {
                case 1:
                    animal = new Lion(animalName, age, weight, numberOfLegs, language);
                    zooList.animalsList.add(animal);
                    break;
                case 2:
                    animal = new Snake(animalName, age, weight, numberOfLegs, language);
                    zooList.animalsList.add(animal);
                    break;
                case 3:
                    animal = new Pigeon(animalName, age, weight, numberOfLegs, language);
                    zooList.animalsList.add(animal);
                    break;
                default:
                    System.out.println("Invalid category");
                    System.exit(0);
                }
                System.out.println("Animal added succesfully to zoo");
                break;
            case 4:
                System.out.println("Enter animal name to add to cage");
                String nameAnimal = string.next();
                int animalIndex;
                flag = 0;
                for (animalIndex = 0; animalIndex < zooList.animalsList.size(); animalIndex++) {
                    if (zooList.animalsList.get(animalIndex).getName().equals(nameAnimal)) {
                        String animalCategory = zooList.animalsList.get(animalIndex).getType();
                        int cageIndex;
                        for (cageIndex = 0; cageIndex < zooList.cagesList.size(); cageIndex++) {
                            if (zooList.cagesList.get(cageIndex).getTypeOfAnimal().equals(animalCategory)) {
                                zooList.addAnimalToCage(zooList.cagesList.get(cageIndex), zooList.animalsList.get(animalIndex));
                                flag = 1;
                                break;
                            }
                        }
                        if (cageIndex == zooList.cagesList.size()) {
                            System.out.println("Cage is not present for given animal");
                            System.exit(0);
                        }
                    }
                }
                if (flag == 0) {
                    System.out.println("Animal does not exist");
                    System.exit(0);
                }
                break;
            case 5:
                System.out.println("Enter animal name to remove from cage");
                String nameOfAnimal = string.next();
                flag = 0;
                for (index = 0; index < zooList.animalsList.size(); index++) {
                    if (zooList.animalsList.get(index).getName().equals(nameOfAnimal)) {
                        zooList.removeAnimalFromCage(zooList.animalsList.get(index));
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    System.out.println("Animal does not exist");
                    System.exit(0);
                }
                break;
            case 6:
                System.out.println("Enter animal name");
                animalName = string.next();
                for (index = 0; index < zooList.animalsList.size(); index++) {
                    if (zooList.animalsList.get(index).getName().equals(animalName)) {
                        zooList.animalsList.get(index).getInformationOfAnimal();
                        break;
                    }
                }
                if (index == zooList.animalsList.size()) {
                    System.out.println("Animal does not exist");
                    System.exit(0);
                }
                break;
            case 7:
                System.out.println("Enter cage Id");
                cageId = sc.nextInt();
                int cageIndex;
                for (cageIndex = 0; cageIndex < zooList.cagesList.size(); cageIndex++) {
                    if (zooList.cagesList.get(cageIndex).getCageId() == cageId) {
                        zooList.cagesList.get(cageIndex).getInformationOfCage();
                        break;
                    }
                }
                break;
            case 8:
                System.out.println("Enter Zone name");
                zoneName = string.next();
                for (int i = 0; i < zooList.listOfZonesInZoo.size(); i++) {
                    if (zooList.listOfZonesInZoo.get(i).getZoneName().equals(zoneName)) {
                        zooList.listOfZonesInZoo.get(i).getInformationOfZone();
                        break;
                    }
                }
                break;
            case 9:
                System.out.println("Enter cage Id");
                cageId = sc.nextInt();
                for (int i = 0; i < zooList.animalsList.size(); i++) {
                    if (zooList.animalsList.get(i).getCageId() == cageId) {
                        zooList.animalsList.get(i).getInformationOfAnimal();
                    }
                }
                break;
            case 10:
                System.out.println("Enter zone name");
                zoneName = string.next();
                for (int i = 0; i < zooList.cagesList.size(); i++) {
                    if (zooList.cagesList.get(i).getZoneId().equals(zoneName)) {
                        for (int j = 0; j < zooList.animalsList.size(); j++) {
                            if (zooList.animalsList.get(j).getCageId() == zooList.cagesList.get(i).getCageId()) {
                                zooList.animalsList.get(j).getInformationOfAnimal();
                            }
                        }
                    }
                }
                break;
            }
        } while (true);
    }
}
