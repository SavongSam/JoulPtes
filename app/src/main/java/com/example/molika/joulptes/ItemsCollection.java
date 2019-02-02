package com.example.molika.joulptes;

import java.util.ArrayList;

public class ItemsCollection {
    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setItemImage("https://media-cdn.tripadvisor.com/media/photo-s/06/6b/fd/6b/deluxe-room-w-extra-bed.jpg");
        item.setItemName("Example Name");
        item.setItemPrice(100);
        item.setItemDesc("Live life with Bali-inspired style, thanks to the clear salt water pool,  plus the state-of-the-art spa overlooking it. There's also an outdoor kitchen, with a 6-burner BBQ and pizza oven. With its spa bath, even the interior has a sparkling welcome.");
        item.setItemReviewsNum(300);
        items.add(item);

        return items;
    }
}
