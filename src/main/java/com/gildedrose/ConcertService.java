package com.gildedrose;

public class ConcertService implements ItemServiceInterface {

    @Override
    public boolean shouldUpdateItem(Item item) {
        return true;
    }

    @Override
    public Item updateQuality(Item item) {

        //Quality logic
        item.quality = item.quality + 1;

        if (item.sellIn < 11) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 6) {
            item.quality = item.quality + 1;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }

        //SellIn logic
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }

        return item;
    }
}
