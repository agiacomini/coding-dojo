package com.giacomini.andrea.bagkata;

import java.util.List;

public class Bag {

    private List<Item> listItems;
    public static final int MAX_BAG_SIZE = 4;
    private Material category;

    public Bag() {}

    public Bag(List<Item> listItem) {
        this.listItems = listItem;
    }
    public Bag(List<Item> listItem, Material category) {
        this.listItems = listItem;
        this.category = category;
    }
    public void addItem(Item newItem) {
        listItems.add(newItem);
    }

    public void addMoreItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public List<Item> listItems(){
        return listItems;
    }
    public boolean isEmpty(){
        if(listItems.size() == 0) return true;
        return false;
    }
    public Material category(){
        return category;
    }
    @Override
    public String toString() {
        return "Bag: " + listItems;
    }
}