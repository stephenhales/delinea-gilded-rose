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
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Sulfuras, Hand of Ragnaros", actual.name);
        assertEquals(5, actual.sellIn);
        assertEquals(6, actual.quality);
    }

    @Test
    void agedBrieMatures() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Aged Brie", actual.name);
        assertEquals(1, actual.sellIn);
        assertEquals(1, actual.quality);
    }

    @Test
    void agedBrieMaturesBugFix() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Aged Brie", actual.name);
        assertEquals(-1, actual.sellIn);
        assertEquals(3, actual.quality);
    }



}
