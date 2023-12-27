package org.example;

class Reptile extends Animal implements Animal_Interface{
    Reptile(String name,String noise,String history) {
        this.noise=noise;
        this.history=history;
        this.name = name;
        this.animalType = "Reptile";
    }

    public void makeNoise() {
        System.out.println(noise);
    }

    public void getInfo() {
        System.out.println("Reptile: " + name);
    }
}
