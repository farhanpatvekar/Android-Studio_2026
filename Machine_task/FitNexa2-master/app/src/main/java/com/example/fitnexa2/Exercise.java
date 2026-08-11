package com.example.fitnexa2;

import java.io.Serializable;
import java.util.List;

public class Exercise implements Serializable {

    String name, force, level, mechanic, equipment;
    List<String> primaryMuscles;
    List<String> secondaryMuscles;
    List<String> instructions;
    List<String> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public List<String> getPrimaryMuscles() {
        return primaryMuscles;
    }

    public void setPrimaryMuscles(List<String> primaryMuscles) {
        this.primaryMuscles = primaryMuscles;
    }

    public List<String> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(List<String> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", force='" + force + '\'' +
                ", level='" + level + '\'' +
                ", mechanic='" + mechanic + '\'' +
                ", equipment='" + equipment + '\'' +
                ", primaryMuscles=" + primaryMuscles +
                ", secondaryMuscles=" + secondaryMuscles +
                ", instructions=" + instructions +
                ", images=" + images +
                '}';
    }
}