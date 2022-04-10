package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.common.item.DrinkItem;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.item.SpawnEggItemBase;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class AbundanceItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Abundance.MOD_ID);

    public static final Supplier<Item> LAVENDER = ITEMS.register("lavender", () -> new ItemNameBlockItem(AbundanceBlocks.LAVENDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final Supplier<Item> LAVENDER_TEA = ITEMS.register("lavender_tea", () -> new DrinkItem(new Item.Properties().food(Foods.LAVENDER_TEA).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> LAVENDER_SALAD = ITEMS.register("lavender_salad", () -> new BowlFoodItem(new Item.Properties().food(Foods.LAVENDER_SALAD).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));

    public static final Supplier<Item> CHICORY_ROOTS = ITEMS.register("chicory_roots", () -> new Item(new Item.Properties().food(Foods.CHICORY_ROOTS).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> PINK_BLOSSOMS = ITEMS.register("pink_blossoms", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final Supplier<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds", () -> new Item(new Item.Properties().food(Foods.SUNFLOWER_SEEDS).tab(CreativeModeTab.TAB_FOOD)));

    public static final Supplier<Item> SCREECHER_SPAWN_EGG = ITEMS.register("screecher_spawn_egg", () -> new SpawnEggItemBase<>(AbundanceEntities.SCREECHER, 0x74A837, 0xB76CCB, true, new Item.Properties()));

    public static final class Foods {
        public static final FoodProperties LAVENDER_TEA = new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).alwaysEat().effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 1), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).build();
        public static final FoodProperties CHICORY_ROOTS = new FoodProperties.Builder().nutrition(2).build();
        public static final FoodProperties LAVENDER_SALAD = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 200), 1.0F).build();
        public static final FoodProperties SUNFLOWER_SEEDS = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().build();
    }
}
