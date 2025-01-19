package com.gildedrose;

public class SulfurasService implements ItemServiceInterface {

    @Override
    public boolean shouldUpdateItem(Item item) {
        return false;
    }

    @Override
    public Item updateQuality(Item item) {
        item.quality = 80; // Legendary quality is always 80
        return item;
    }
}
