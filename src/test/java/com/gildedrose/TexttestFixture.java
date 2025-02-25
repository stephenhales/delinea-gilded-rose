package com.gildedrose;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class TexttestFixture {
    public static void main(String[] args) {

        File file = new File("target/test-output/TexttestFixture.received.txt");
        file.getParentFile().mkdirs();

        try (PrintStream out = new PrintStream(file)) {
            out.println("OMGHAI!");

            Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras", 0, 80), //
                new Item("Sulfuras", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

            GildedRose app = new GildedRose(items);

            int days = 10;
            if (args.length > 0) {
                days = Integer.parseInt(args[0]) + 1;
            }

            for (int i = 0; i < days; i++) {
                out.println("-------- day " + i + " --------");
                out.println("name, sellIn, quality");
                for (Item item : items) {
                    out.println(item);
                }
                if (i < days - 1) {
                    out.println();
                }
                app.updateQuality();
            }


        } catch (final IOException e) {
            System.err.println("Problem! " + e.getMessage());
        }
    }

}
