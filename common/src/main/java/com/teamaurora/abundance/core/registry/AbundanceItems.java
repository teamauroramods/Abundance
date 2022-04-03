package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import java.util.function.Supplier;

public class AbundanceItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Abundance.MOD_ID);

    public static final Supplier<Item> PINK_BLOSSOMS = registerItem("pink_blossoms", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final Supplier<Item> LAVENDER = registerItem("lavender", () -> new ItemNameBlockItem(AbundanceBlocks.LAVENDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static Supplier<Item> registerItem(String id, Supplier<Item> item) {
        Supplier<Item> register = ITEMS.register(id, item);
        return register;
    }
}
