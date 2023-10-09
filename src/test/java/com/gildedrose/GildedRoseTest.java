package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    GildedRose app = new GildedRose(null);
    Item regular = new Item("Elixir of the Mongoose", 3, 5);
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20);
    Item brie = new Item("Aged Brie", 2, 0);
    Item legendary = new Item("Sulfuras, Hand of Ragnaros", -1, 80);

    @Test
    void test_regular_item() {
        test(regular, 2, 4);
    }

    @Test
    void test_regular_items() {
        app.items = new Item[]{regular, new Item("foo", 10, 20)};
        app.updateQuality();
        assertEquals(2, regular.sellIn, "sellIn item 1");
        assertEquals(9, app.items[1].sellIn, "sellIn item 2");
        assertEquals(4, regular.quality, "quality item 1");
        assertEquals(19, app.items[1].quality, "quality item 2");
    }

    @Test
    void test_regular_degrades_twice_as_fast_after_sellIn() {
        regular.sellIn = 0;
        test(regular, -1, 3);
    }

    @Test
    void test_regular_quality_not_negative() {
        regular.quality = 0;
        test(regular, 2, 0);
    }

    @Test
    void test_regular_combo() {
        regular.sellIn = 0; // degrade twice as fast (so -2)
        regular.quality = 1; // 1 - 2 = -1 but quality should not go under 0
        test(regular, -1, 0);
    }

    @Test
    void test_appreciating() {
        test(brie, 1, 1);
    }

    @Test
    void test_appreciating_max_50() {
        brie.quality = 50;
        test(brie, 1, 50);
    }

    @Test
    void test_appreciating_also_doubled_after_sellIn() {
        brie.sellIn = 0;
        test(brie, -1, 2);
    }

    @Test
    void test_appreciating_combo() {
        brie.quality = 49;
        brie.sellIn = 0;
        test(brie, -1, 50);
    }

    @Test
    void test_legendary_will_not_change() {
        test(legendary, -1, 80);
        legendary.sellIn = 10;
        test(legendary, 10, 80);
    }

    @Test
    void test_backstage() {
        test(backstage, 11, 21);
    }

    @Test
    void test_backstage_inc_by_2_when_close_to_sellIn() {
        backstage.sellIn = 10;
        test(backstage, 9, 22);
    }

    @Test
    void test_backstage_inc_by_3_when_closer_to_sellIn() {
        backstage.sellIn = 5;
        test(backstage, 4, 23);
    }

    @Test
    void test_backstage_quality_0_after_sellIn() {
        backstage.sellIn = 0;
        test(backstage, -1, 0);
    }


    void test(Item item, int sellIn, int quality) {
        app.items = new Item[]{item};
        app.updateQuality();
        assertEquals(sellIn, item.sellIn, "sellIn");
        assertEquals(quality, item.quality, "quality");
    }

}
