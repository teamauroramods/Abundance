package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class AbundanceBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, Abundance.MOD_ID);

    private static Supplier<Block> registerBlock(String id, Supplier<Block> block, Item.Properties properties) {
        Supplier<Block> register = BLOCKS.register(id, block);
        AbundanceItems.ITEMS.register(id, () -> new BlockItem(register.get(), properties));
        return register;
    }

    private static Supplier<Block> registerBlockNoItem(String id, Supplier<Block> block) {
        Supplier<Block> register = BLOCKS.register(id, block);
        return register;
    }
}
