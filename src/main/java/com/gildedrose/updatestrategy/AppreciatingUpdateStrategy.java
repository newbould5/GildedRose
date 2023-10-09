package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

public class AppreciatingUpdateStrategy implements UpdateStrategy {


    @Override
    public void updateQuality(Item item) {
        if(item.quality < 50) {
            item.quality++;
            if(item.sellIn <= 0 && item.quality < 50) {
                item.quality++;
            }
        }
    }

}
