package org.example;

class Amphibian extends Animal implements Animal_Interface{
    Amphibian(String name,String noise,String history) {
        this.noise=noise;
        this.history=history;
        this.name = name;
        this.animalType = "Amphibian";
    }

    public void makeNoise() {
        System.out.println(noise);
    }

    public void getInfo() {
        System.out.println("Amphibian: " + name);
    }
}
