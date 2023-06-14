package com.giacomini.andrea.bagkata;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.giacomini.andrea.bagkata.Material.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackPackShould {
    private BackPack backpack;
    private List<Item> listItems;
    private List<Bag> listBags;

    @Before
    public void
    initialise(){
        listItems = new ArrayList<>();
        listBags = new ArrayList<>();
        backpack = new BackPack();

        listBags.add(new Bag(new ArrayList<>(), METALS));
        listBags.add(new Bag(new ArrayList<>()));
        listBags.add(new Bag(new ArrayList<>(), WEAPONS));
        listBags.add(new Bag(new ArrayList<>()));
        backpack.addBagsToBackPack(listBags);
    }

    @Test
    public void
    add_new_extra_item_when_backpack_is_empty(){
        listItems.add(new Item("Copper", METALS));
        assertThat(backpack.addItems(listItems), is("BackPack: [Copper]"));
    }

    @Test
    public void
    add_new_extra_item_when_backpack_has_an_item(){
        listItems.add(new Item("Leather",NO_CATEGORY));
        backpack.addItems(listItems);

        List<Item> listNewItems = new ArrayList<>();
        listNewItems.add(new Item("Copper", METALS));
        assertThat(backpack.addItems(listNewItems), is("BackPack: [Leather, Copper]"));
    }

    @Test
    public void
    add_new_extra_item_when_backpack_is_full(){
        listItems.add(new Item("Leather",NO_CATEGORY));
        listItems.add(new Item("Iron", METALS));
        listItems.add(new Item("Copper", METALS));
        listItems.add(new Item("Marigold",NO_CATEGORY));
        listItems.add(new Item("Wool",NO_CATEGORY));
        listItems.add(new Item("Gold", METALS));
        listItems.add(new Item("Silk",NO_CATEGORY));
        listItems.add(new Item("Copper", METALS));
        backpack.addItems(listItems);

        List<Item> listNewItems = new ArrayList<>();
        listNewItems.add(new Item("Copper",METALS));

        assertThat(backpack.addItems(listNewItems), is("BackPack: [Leather, Iron, Copper, Marigold, Wool, Gold, Silk, Copper], Bag: [Copper]"));
    }

    @Test
    public void
    add_more_new_extra_item_when_backpack_is_empty(){
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Marigold",NO_CATEGORY));
        assertThat(backpack.addItems(listItems), is("BackPack: [Copper, Iron, Marigold]"));
    }

    @Test
    public void
    add_more_new_extra_item_when_backpack_is_full(){
        listItems.add(new Item("Leather",NO_CATEGORY));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Marigold",NO_CATEGORY));
        listItems.add(new Item("Wool",NO_CATEGORY));
        listItems.add(new Item("Gold",METALS));
        listItems.add(new Item("Silk",NO_CATEGORY));
        listItems.add(new Item("Copper",METALS));
        backpack.addItems(listItems);

        List<Item> listNewItems = new ArrayList<>();
        listNewItems.add(new Item("Copper",METALS));
        listNewItems.add(new Item("Cherry Blossom",NO_CATEGORY));

        assertThat(backpack.addItems(listNewItems), is("BackPack: [Leather, Iron, Copper, Marigold, Wool, Gold, Silk, Copper], Bag: [Copper, Cherry Blossom]"));
    }

    @Test
    public void
    clear_empty_backpack(){
        assertThat(backpack.emptyBackPack(), is("BackPack: []"));
    }

    @Test
    public void
    add_items_when_backpack_is_full_and_bag_is_half(){
        listItems.add(new Item("Leather",NO_CATEGORY));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Marigold",NO_CATEGORY));
        listItems.add(new Item("Wool",NO_CATEGORY));
        listItems.add(new Item("Gold",METALS));
        listItems.add(new Item("Silk",NO_CATEGORY));
        listItems.add(new Item("Copper",METALS));
        backpack.addItems(listItems);

        List<Item> listItemBag = new ArrayList<>();
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Cherry Blossom",NO_CATEGORY));
        backpack.bags().get(0).addMoreItems(listItemBag);

        List<Item> listNewItems = new ArrayList<>();
        listNewItems.add(new Item("Copper",METALS));
        listNewItems.add(new Item("Gold",METALS));
        assertThat(backpack.addItems(listNewItems), is("BackPack: [Leather, Iron, Copper, Marigold, Wool, Gold, Silk, Copper], Bag: [Copper, Cherry Blossom, Copper, Gold]"));
    }

    @Test
    public void
    add_items_when_backpack_is_full_and_first_bag_too(){
        listItems.add(new Item("Leather",NO_CATEGORY));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Marigold",NO_CATEGORY));
        listItems.add(new Item("Wool",NO_CATEGORY));
        listItems.add(new Item("Gold",METALS));
        listItems.add(new Item("Silk",NO_CATEGORY));
        listItems.add(new Item("Copper",METALS));
        backpack.addItems(listItems);

        List<Item> listItemBag = new ArrayList<>();
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Cherry Blossom",NO_CATEGORY));
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Gold",METALS));
        backpack.bags().get(0).addMoreItems(listItemBag);

        List<Item> listNewItems = new ArrayList<>();
        listNewItems.add(new Item("Silk",NO_CATEGORY));
        listNewItems.add(new Item("Wool",NO_CATEGORY));
        assertThat(backpack.addItems(listNewItems), is("BackPack: [Leather, Iron, Copper, Marigold, Wool, Gold, Silk, Copper], Bag: [Copper, Cherry Blossom, Copper, Gold], Bag: [Silk, Wool]"));
    }

    @Test
    public void
    add_items_when_backpack_is_full_and_first_two_bag_too(){
        listItems.add(new Item("Leather",NO_CATEGORY));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Marigold",NO_CATEGORY));
        listItems.add(new Item("Wool",NO_CATEGORY));
        listItems.add(new Item("Gold",METALS));
        listItems.add(new Item("Silk",NO_CATEGORY));
        listItems.add(new Item("Copper",METALS));
        backpack.addItems(listItems);

        List<Item> listItemBag = new ArrayList<>();
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Cherry Blossom",NO_CATEGORY));
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Gold",METALS));
        backpack.bags().get(0).addMoreItems(listItemBag);

        List<Item> listItemBag2 = new ArrayList<>();
        listItemBag2.add(new Item("Gold",METALS));
        listItemBag2.add(new Item("Copper",METALS));
        listItemBag2.add(new Item("Cherry Blossom",NO_CATEGORY));
        listItemBag2.add(new Item("Copper",METALS));
        backpack.bags().get(1).addMoreItems(listItemBag2);


        List<Item> listNewItems = new ArrayList<>();
        listNewItems.add(new Item("Silk",NO_CATEGORY));
        listNewItems.add(new Item("Wool",NO_CATEGORY));
        assertThat(backpack.addItems(listNewItems), is("BackPack: [Leather, Iron, Copper, Marigold, Wool, Gold, Silk, Copper], Bag: [Copper, Cherry Blossom, Copper, Gold], Bag: [Gold, Copper, Cherry Blossom, Copper], Bag: [Silk, Wool]"));
    }

    @Test
    public void
    organize_items_in_bags(){
        listItems.add(new Item("Leather",CLOTHES));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Marigold",HERBS));
        listItems.add(new Item("Wool",CLOTHES));
        listItems.add(new Item("Gold",METALS));
        listItems.add(new Item("Silk",CLOTHES));
        listItems.add(new Item("Copper",METALS));
        backpack.addItems(listItems);

        List<Item> listItemBag = new ArrayList<>();
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Cherry Blossom",HERBS));
        backpack.bags().get(0).addMoreItems(listItemBag);

        assertThat(backpack.organizeItems(), is("BackPack: [Cherry Blossom, Iron, Leather, Marigold, Silk, Wool], "
                                                    + "Bag: [Copper, Copper, Copper, Gold]"));
    }

    @Test
    public void
    organize_items_in_bags_2(){
        listItems.add(new Item("Leather",CLOTHES));
        listItems.add(new Item("Iron",METALS));
        listItems.add(new Item("Copper",METALS));
        listItems.add(new Item("Marigold",HERBS));
        listItems.add(new Item("Wool",CLOTHES));
        listItems.add(new Item("Gold",METALS));
        listItems.add(new Item("Silk",CLOTHES));
        listItems.add(new Item("Axe",WEAPONS));
        backpack.addItems(listItems);

        List<Item> listItemBag = new ArrayList<>();
        listItemBag.add(new Item("Copper",METALS));
        listItemBag.add(new Item("Cherry Blossom",HERBS));
        backpack.bags().get(0).addMoreItems(listItemBag);

        assertThat(backpack.organizeItems(), is("BackPack: [Cherry Blossom, Leather, Marigold, Silk, Wool], "
                                                    + "Bag: [Copper, Copper, Gold, Iron], "
                                                    + "Bag: [Axe]"));
    }
}