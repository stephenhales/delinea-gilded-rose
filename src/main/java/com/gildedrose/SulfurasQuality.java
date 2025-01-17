package com.gildedrose;

public class SulfurasQuality implements itemInterface {

    @Override
    public boolean shouldUpdateItem(Item item) {
        return false;
    }

    @Override
    public Item updateQuality(Item item) {
        return item;
    }
}
