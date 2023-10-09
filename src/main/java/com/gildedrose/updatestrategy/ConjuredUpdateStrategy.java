package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

/**
 * A conjured {@link Item} behaves like similar to the {@link DefaultUpdateStrategy} but doubled meaning:
 * Quality will decrease by -2 and by -4 once over sellIn. Just like the default the quality will never go under 0 and the sellIn will decrease by 1.
 */
public class ConjuredUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateQuality(Item item) {
        if(item.quality > 0) {
            item.quality -= 2;
            if(item.sellIn <= 0) {
                item.quality -= 2;
            }
        }
    }
}
