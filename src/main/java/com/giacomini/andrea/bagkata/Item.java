package com.giacomini.andrea.bagkata;

public class Item implements Comparable<Item>{

    private String name;
    private Material category;

    public Item(String name, Material category) {
        this.name = name;
        this.category = category;
    }
    public String name(){
        return name;
    }
    public Material category(){
        return category;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
//        return 0;
    }
}
