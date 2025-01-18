package com.gildedrose;


//chase.barrett@delinea.com
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            // Sulfuras (Not hand of Ragnaros)
            if (items[i].name.equals("Sulfuras")){
                continue;
            }

            // Aged Brie
            if (items[i].name.equals("Aged Brie")){
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
                items[i].sellIn = items[i].sellIn - 1;
                continue;
            }

            //Backstage Passes
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                //Quality logic
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }

                //SellIn logic
                items[i].sellIn = items[i].sellIn - 1;
                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }

                continue;
            }

            // Quality logic GENERIC
            if (items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }


            //SellIn logic GENERIC
            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].sellIn < 0) {
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }
            }
        }
    }
}
