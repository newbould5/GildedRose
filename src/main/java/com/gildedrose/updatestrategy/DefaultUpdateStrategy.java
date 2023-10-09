package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

/**
 * The default strategy for updating item quality and sellIn.
 * SellIn will always be decreased by 1.
 * Quality will decrease by -1 and by -2 once over sellIn. Will never go under 0.
 */
public class DefaultUpdateStrategy implements UpdateStrategy{

    @Override
    public void updateQuality(Item item) {
        if(item.quality > 0) {
            item.quality--;
            if(item.sellIn <= 0 && item.quality > 0) {
                item.quality--;
            }
        }
    }

}
