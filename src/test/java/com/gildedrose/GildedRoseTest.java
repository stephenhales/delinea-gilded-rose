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

    // "Aged Brie" actually increases in Quality the older it gets
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

    // "Aged Brie" Bug fix - the expected results in test Fixture were wrong
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

    // Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void sellInCausesQualityDegrade() {
        Item[] items = new Item[] { new Item("Cookies", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Cookies", actual.name);
        assertEquals(-1, actual.sellIn);
        assertEquals(0, actual.quality);
    }

    // The Quality of an item is never negative
    @Test
    void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("Cookies", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Cookies", actual.name);
        assertEquals(-1, actual.sellIn);
        assertEquals(0, actual.quality);
    }

    // The Quality of an item is never more than 50
    @Test
    void qualityMaxOf50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Aged Brie", actual.name);
        assertEquals(-1, actual.sellIn);
        assertEquals(50, actual.quality);
    }

    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void sulfurasShouldBeStaticItem() {
        Item[] items = new Item[] { new Item("Sulfuras", 0, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Sulfuras", actual.name);
        assertEquals(0, actual.sellIn);
        assertEquals(45, actual.quality);
    }

    // "Backstage passes" increase in Quality as their SellIn value approaches;
    @Test
    void concertQualityDefaultIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", actual.name);
        assertEquals(19, actual.sellIn);
        assertEquals(11, actual.quality);
    }

    // "Backstage passes" increase in Quality as their SellIn value approaches;
    // Quality increases by 2 when there are 10 days or less
    @Test
    void concertQuality10DaysIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", actual.name);
        assertEquals(9, actual.sellIn);
        assertEquals(12, actual.quality);
    }

    // "Backstage passes" increase in Quality as their SellIn value approaches;
    // Quality increases by 3 when there are 5 days or less
    @Test
    void concertQuality5DaysIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", actual.name);
        assertEquals(4, actual.sellIn);
        assertEquals(13, actual.quality);
    }

    // "Backstage passes" increase in Quality as their SellIn value approaches;
    // Quality increases by 3 when there are 5 days or less
    @Test
    void concertQualityLastDayEdgeCase() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", actual.name);
        assertEquals(0, actual.sellIn);
        assertEquals(13, actual.quality);
    }

    // "Backstage passes" increase in Quality as their SellIn value approaches;
    // Quality increases by 3 when there are 5 days or less but
    @Test
    void concertQuality0DaysCausesQualityDrop() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item actual = app.items[0];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", actual.name);
        assertEquals(-1, actual.sellIn);
        assertEquals(0, actual.quality);
    }
}
