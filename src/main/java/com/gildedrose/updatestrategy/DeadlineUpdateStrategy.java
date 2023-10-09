package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

/**
 * Quality increases when approaching sellIn and once past sellIn quality will be 0.
 * Quality will increase by 3 when sellIn 1-5.
 * Quality will increase by 2 when sellIn 6-10.
 * For sellIn > 10 quality will increase by 1.
 * Quality has a max value of 50.
 *
 * SellIn will decrease by 1 like the default.
 */
public class DeadlineUpdateStrategy implements UpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        if(item.sellIn <= 0) {
            item.quality = 0;
        } else if(item.sellIn <= 5) {
            item.quality +=3;
        } else if(item.sellIn <= 10) {
            item.quality += 2;
        } else {
            item.quality++;
        }

        if(item.quality > 50) {
            item.quality = 50;
        }
    }

}
