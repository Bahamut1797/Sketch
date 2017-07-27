package com.company.services.sketch.Modelos;

public class Food {
    private String name;
    private double price;
    private String description;
    private int thumbnail;

    public Food() {

    }

    public Food(String name, double price, String description, int thumbnail) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
