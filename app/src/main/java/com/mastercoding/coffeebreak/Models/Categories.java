package com.mastercoding.coffeebreak.Models;

import java.util.List;

public class Categories {
    private int imageItem;
    private String nameItem;
    private String descriptionItem;
    private String price;


    //Empty constructor.
    public Categories() {
    }
    //default constructor.

    public Categories(int imageItem, String nameItem, String descriptionItem, String price) {
        this.imageItem = imageItem;
        this.nameItem = nameItem;
        this.descriptionItem = descriptionItem;
        this.price = price;
    }
    //Getter and setter.

    public int getImageItem() {
        return imageItem;
    }

    public void setImageItem(int imageItem) {
        this.imageItem = imageItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDescriptionItem() {
        return descriptionItem;
    }

    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
