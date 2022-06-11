package com.teamaurora.abundance.common.block;

import gg.moonflower.pollen.api.item.TabFiller;
import net.minecraft.core.NonNullList;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallFlowerBlock;

import java.util.function.Supplier;

/**
 * A {@link TallFlowerBlock} that inserts its item after vanilla tall flowers.
 * @author ebo2022
 * @since 2.0.0
 */
public class AbundanceTallFlowerBlock extends TallFlowerBlock {
    public AbundanceTallFlowerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemCategory(CreativeModeTab category, NonNullList<ItemStack> items) {
        TabFiller.insert(new ItemStack(this), false, items, stack -> stack.getItem() == Items.PEONY);
    }
}
