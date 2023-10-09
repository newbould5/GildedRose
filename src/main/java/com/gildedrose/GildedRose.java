package com.gildedrose;

import com.gildedrose.updatestrategy.UpdateStrategyFactory;

class GildedRose {
    Item[] items;

    private UpdateStrategyFactory strategyFactory = new UpdateStrategyFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items ) {
            // find the correct strategy to update the item and perform the strategy
            strategyFactory.getUpdateStrategy(item).execute(item);
        }
    }

}
