package com.gildedrose;


//chase.barrett@delinea.com
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            ItemServiceInterface service = new DefaultItemService();

            // Sulfuras (Not hand of Ragnaros)
            if (items[i].name.equals("Sulfuras")){
                service = new SulfurasService();
            }

            // Aged Brie
            if (items[i].name.equals("Aged Brie")){
                service = new AgedBrieService();
            }

            //Backstage Passes
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                service = new ConcertService();
            }

            if(service.shouldUpdateItem(items[i])){
                service.updateQuality(items[i]);
            }

        }
    }
}
