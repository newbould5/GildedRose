package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public interface UpdateStrategy {

    default void execute(Item item) {
        updateQuality(item);
        updateSellIn(item);
    }

    void updateQuality(Item item);

    default void updateSellIn(Item item) {
        item.sellIn--;
    }

}
