package ZooManagementSystem;

class Animal {
    private String name;
    protected String type;
    private int cageId;
    private int age;
    private int weight;
    private int numberOfLegs;
    private String language;

    public Animal(String name, int age, int weight, int numberOfLegs, String language) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.numberOfLegs = numberOfLegs;
        this.language = language;
        cageId = 0;
    }

    public String getName() {
        return name;
    }

    public void setCageId(int id) {
        cageId = id;
    }

    public int getCageId() {
        return cageId;
    }

    public void getInformationOfAnimal() {
        System.out.println("Animal name: " + name);
        System.out.println("Animal age: " + age);
        System.out.println("Animal is in cage: " + cageId);
        System.out.println("Animal weight: " + weight);
        System.out.println("Animal no of legs: " + numberOfLegs);
        System.out.println("Animal language is: " + language);
    }

    public String getType() {
        return type;
    }
    
    public String getSound() {
        return language;
    }
}

class Mammal extends Animal {
    public boolean hasHairs;

    public Mammal(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        this.hasHairs = true;
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal has hairs on body: " + hasHairs);
    }
}

class Reptiles extends Animal {
    public boolean hasScales;

    public Reptiles(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        this.hasScales = true;
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal has scales: " + hasScales);
    }
}

class Birds extends Animal {
    private boolean hasFeathers;

    public Birds(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        this.hasFeathers = true;
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal has feathers: " + hasFeathers);
    }

    public void canFly() {
        System.out.println("All birds can fly.");
    }
}

class Lion extends Mammal {
    public Lion(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        type = "Lion";
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal type is: " + type);
    }
}

class Elephant extends Mammal {
    public Elephant(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        type = "Elephant";
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal type is: " + type);
    }
}

class Snake extends Reptiles {
    public Snake(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        type = "Snake";
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal type is: " + type);
    }
}

class Crocodile extends Reptiles {
    public Crocodile(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        type = "Crocodile";
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal type is: " + type);
    }
}

class Pigeon extends Birds {
    public Pigeon(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        type = "Pigeon";
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal type is: " + type);
    }
}

class Ostrich extends Birds {
    public Ostrich(String name, int age, int weight, int numberOfLegs, String language) {
        super(name, age, weight, numberOfLegs, language);
        type = "Ostrich";
    }

    public void getInformationOfAnimal() {
        super.getInformationOfAnimal();
        System.out.println("Animal type is: " + type);
    }
}
