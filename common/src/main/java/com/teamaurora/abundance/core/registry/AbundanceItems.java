package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.item.DrinkItem;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import java.util.function.Supplier;

public class AbundanceItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Abundance.MOD_ID);

    public static final Supplier<Item> LAVENDER = registerItem("lavender", () -> new ItemNameBlockItem(AbundanceBlocks.LAVENDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final Supplier<Item> LAVENDER_TEA = registerItem("lavender_tea", () -> new DrinkItem(new Item.Properties().food(Foods.LAVENDER_TEA).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));

    public static final Supplier<Item> CHICORY_ROOTS = registerItem("chicory_roots", () -> new Item(new Item.Properties().food(Foods.CHICORY_ROOTS).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> PINK_BLOSSOMS = registerItem("pink_blossoms", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static Supplier<Item> registerItem(String id, Supplier<Item> item) {
        Supplier<Item> register = ITEMS.register(id, item);
        return register;
    }

    public static final class Foods {
        public static final FoodProperties LAVENDER_TEA = new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).alwaysEat().effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 1), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).build();
        public static final FoodProperties CHICORY_ROOTS = new FoodProperties.Builder().nutrition(2).build();
    }
}
