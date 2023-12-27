package org.example;

class Mammal extends Animal implements Animal_Interface {
    Mammal(String name,String noise,String history) {
        this.noise=noise;
        this.history=history;
        this.name = name;
        this.animalType = "Mammal";
    }
    public void makeNoise() {
        System.out.println(noise);
    }
    public void getInfo() {
        System.out.println("Mammal: " + name);
    }
}