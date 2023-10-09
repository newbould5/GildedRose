package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

/**
 * Legendary items do not change at all.
 */
public class LegendaryUpdateStrategy implements UpdateStrategy {

    @Override
    public void execute(Item item) {}

    @Override
    public void updateQuality(Item item) {}

    @Override
    public void updateSellIn(Item item) {}

}
