package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testUJUnit() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sulfurasNotUpdated() {
        Item[] items = new Item[] { new Item("Sulfuras", 5, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Sulfuras", actual.name);
        assertEquals(5, actual.sellIn);
        assertEquals(6, actual.quality);
    }

}
