package com.gildedrose.updatestrategy;

import com.gildedrose.Item;

import java.util.Map;

/**
 * Factory to retrieve the {@link UpdateStrategy} to use with a certain {@link Item}.
 */
public class UpdateStrategyFactory {

    private final Map<String, UpdateStrategy> map = Map.of(
        "+5 Dexterity Vest", new DefaultUpdateStrategy(),
        "Aged Brie", new AppreciatingUpdateStrategy(),
        "Elixir of the Mongoose", new DefaultUpdateStrategy(),
        "Sulfuras, Hand of Ragnaros", new LegendaryUpdateStrategy(),
        "Backstage passes to a TAFKAL80ETC concert", new DeadlineUpdateStrategy(),
        "Conjured Mana Cake", new ConjuredUpdateStrategy()
    );

    /**
     * @return the corresponding {@link UpdateStrategy}. If no explicit mapping was found the {@link DefaultUpdateStrategy} will be returned.
     */
    public UpdateStrategy getUpdateStrategy(Item item) {
        return map.getOrDefault(item.name, new DefaultUpdateStrategy());
    }
}
