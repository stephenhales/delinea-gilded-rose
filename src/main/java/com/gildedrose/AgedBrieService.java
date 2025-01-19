package com.gildedrose;

public class AgedBrieService implements ItemServiceInterface {

    @Override
    public boolean shouldUpdateItem(Item item) {
        return true;
    }

    @Override
    public Item updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;

        return item;
    }
}
