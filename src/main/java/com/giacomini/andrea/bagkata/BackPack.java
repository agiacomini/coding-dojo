package com.giacomini.andrea.bagkata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

import static com.giacomini.andrea.bagkata.Bag.MAX_BAG_SIZE;
import static com.giacomini.andrea.bagkata.Material.*;

public class BackPack {
    public static final int MAX_BACKPACK_SIZE = 8;
    private List<Item> items;
    private List<Bag> bags;
    public BackPack(){
        items = new ArrayList<>();
        bags = new ArrayList<>();
    }
    public List<Bag> bags(){
        return bags;
    }
    BiPredicate<Item, Bag> checkCategory = (item, bag)  -> bag.category() != null && bag.category().equals(item.category());
    public String addItems(List<Item> listItems){
        for (Item newItem: listItems) {
            if(items.size() >= MAX_BACKPACK_SIZE){
                for (Bag bag: bags) {
                    if(bag.listItems().size() >= MAX_BAG_SIZE){
                        continue;
                    }
                    bag.addItem(newItem);
                    break;
                }
            } else{
                items.add(newItem);
            }
        }
        return this.toString();
    }
    public String addBags(List<Bag> listBags){
        for (Bag bag: listBags) {
            bags.add(bag);
        }
        return this.toString();
    }
    public String emptyBackPack() {
        items.clear();
        return this.toString();
    }
    public String organizeItems(){
        organizeBackPackItems();
        for (Bag bag: bags) {
            List<Item> appoggio = new ArrayList<>();
            for (int i = 0; i < bag.listItems().size() ; i++) {
                if(!checkCategory.test(bag.listItems().get(i), bag)){
                    appoggio.add(bag.listItems().get(i));
                    bag.listItems().remove(i);
                }
            }
            if (!appoggio.isEmpty()) addItems(appoggio);
            organizeBackPackItems();
            Collections.sort(bag.listItems());
        }
        Collections.sort(items);
        return this.toString();
    }
    private void organizeBackPackItems(){
        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
            switch (items.get(i).category()){
                case METALS: organizeByMaterialCategory(i, METALS); break;
                case CLOTHES: organizeByMaterialCategory(i, CLOTHES); break;
                case HERBS: organizeByMaterialCategory(i, HERBS); break;
                case WEAPONS: organizeByMaterialCategory(i, WEAPONS); break;
            }
        }
    }
    private void organizeByMaterialCategory(int index, Material material){
        if(items.get(index).category().equals(material)){
            for (Bag bag: bags) {
                if(checkCategory.test(items.get(index), bag)){
                    if(bag.listItems().size() >= MAX_BAG_SIZE){
                        continue;
                    }
                    bag.addItem(items.get(index));
                    items.remove(index);
                    break;
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BackPack: " + items);
        for (Bag bag: bags) {
            sb.append(!bag.isEmpty() ? ", " + bag : "");
        }
        return sb.toString();
    }
}