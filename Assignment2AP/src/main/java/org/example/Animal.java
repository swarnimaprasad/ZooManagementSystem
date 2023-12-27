package org.example;
abstract class Animal {
    protected String name;
    public String getAnimalType() {
        return animalType;
    }
    protected String animalType;
    protected String noise;
    protected String history;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return animalType;
    }
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    public String getNoise() {
        return noise;
    }
    public void setNoise(String noise) {
        this.noise = noise;
    }
    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    abstract void makeNoise();
    abstract void getInfo();
}