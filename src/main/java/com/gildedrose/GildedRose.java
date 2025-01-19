package com.gildedrose;


//chase.barrett@delinea.com
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            ItemServiceInterface service = getItemService(item.name);

            if (service.shouldUpdateItem(item)) {
                service.updateQuality(item);
            }

        }
    }

    private ItemServiceInterface getItemService(String name){
        switch (name){
            case "Sulfuras": return new SulfurasService();
            case "Aged Brie": return new AgedBrieService();
            case "Backstage passes to a TAFKAL80ETC concert": return new ConcertService();
            default: return new DefaultItemService();
        }
    }
}
