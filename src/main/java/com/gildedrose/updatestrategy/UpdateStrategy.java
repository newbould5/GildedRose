package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public interface UpdateStrategy {

    int MAX = 50;
    int MIN = 0;

    default void execute(Item item) {
        updateQuality(item);
        if (item.quality > MAX) item.quality = MAX;
        if (item.quality < MIN) item.quality = MIN;
        updateSellIn(item);
    }

    void updateQuality(Item item);

    default void updateSellIn(Item item) {
        item.sellIn--;
    }

}
