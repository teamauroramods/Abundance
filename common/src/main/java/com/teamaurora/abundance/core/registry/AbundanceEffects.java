package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.potion.DeafnessEffect;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;

import java.util.function.Supplier;

public class AbundanceEffects {
    public static final PollinatedRegistry<Potion> POTIONS = PollinatedRegistry.create(Registry.POTION, Abundance.MOD_ID);
    public static final PollinatedRegistry<MobEffect> MOB_EFFECTS = PollinatedRegistry.create(Registry.MOB_EFFECT, Abundance.MOD_ID);

    public static final Supplier<MobEffect> DEAFNESS = MOB_EFFECTS.register("deafness", DeafnessEffect::new);

    public static final Supplier<Potion> DEAFNESS_NORMAL = POTIONS.register("deafness", ()-> new Potion(new MobEffectInstance(DEAFNESS.get(), 1800)));
    public static final Supplier<Potion> DEAFNESS_LONG = POTIONS.register("deafness_long", ()-> new Potion(new MobEffectInstance(DEAFNESS.get(), 3600)));
    public static final Supplier<Potion> DEAFNESS_STRONG = POTIONS.register("deafness_strong", ()-> new Potion(new MobEffectInstance(DEAFNESS.get(), 864, 1)));

    public static void registerBrewingRecipes() {
        PotionBrewing.addMix(Potions.AWKWARD, AbundanceItems.SCREECHER_TAIL.get(), DEAFNESS_NORMAL.get());
        PotionBrewing.addMix(DEAFNESS_NORMAL.get(), Items.GLOWSTONE_DUST, DEAFNESS_STRONG.get());
        PotionBrewing.addMix(DEAFNESS_NORMAL.get(), Items.REDSTONE, DEAFNESS_LONG.get());
    }
}
