package ZooManagementSystem;

import java.util.*;

enum AnimalEnum {
    AnimalLion("Lion", "Mammal"), AnimalTiger("Tiger", "Mammal"), AnimalPigeon("Pigeon", "Bird"), 
        AnimalOstrich("Ostrich", "Bird"), AnimalSnake("Snake", "Reptile"), AnimalCrocodile("Crocodile", "Reptile");
    String category;
    String name;

    AnimalEnum(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
};

public class ZooLists {
    public ArrayList<ZonesInZoo> listOfZonesInZoo = new ArrayList<ZonesInZoo>();
    public ArrayList<Cage> cagesList = new ArrayList<Cage>();
    public ArrayList<Animal> animalsList = new ArrayList<Animal>();

    public void addAnimalToCage(Cage cage, Animal animal) {
        if (cage.getCageSpareCapacity() >= 1) {
            int capacity = cage.getCageSpareCapacity();
            if (capacity >= 1) {
                animal.setCageId(cage.getCageId());
                cage.setCageSpareCapacity(capacity);
                System.out.println("Animal is allocated to cage");
                animal.setCageId(cage.getCageId());
                capacity--;
            } else {
                int quantity = cage.getCageQuantity();
                if (quantity >= 1) {
                    animal.setCageId(cage.getCageId());
                    System.out.println("Animal is allocated to cage");
                    animal.setCageId(cage.getCageId());
                    cage.setCageQuantity(quantity);
                    cage.setCageSpareCapacity(cage.getTotalCapacity());
                    quantity--;
                } else {
                    System.out.println("Cages are not sufficient");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Cages are not sufficient");
            System.exit(0);
        }
    }

    public void removeAnimalFromCage(Animal animal) {
        if (animal.getCageId() > 0) {
            int spareCapacity = cagesList.get(animal.getCageId() - 1).getCageSpareCapacity();
            int quantity = cagesList.get(animal.getCageId() - 1).getCageQuantity();
            if (spareCapacity < cagesList.get(animal.getCageId() - 1).getTotalCapacity()) {
                spareCapacity++;
                cagesList.get(animal.getCageId() - 1).setCageSpareCapacity(spareCapacity);
            } else if (spareCapacity == cagesList.get(animal.getCageId() - 1).getTotalCapacity()) {
                quantity++;
                cagesList.get(animal.getCageId() - 1).setCageSpareCapacity(0);
                cagesList.get(animal.getCageId() - 1).setCageQuantity(quantity);
            }
            animalsList.remove(animal);
            System.out.println("Animal is removed from cage");
        } else {
            System.out.println("Animal is not in cage");
            System.exit(0);
        }
    }
}
