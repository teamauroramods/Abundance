package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.entity.living.Screecher;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.EntityAttributeRegistry;
import gg.moonflower.pollen.api.registry.PollinatedEntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class AbundanceEntities {
    public static final PollinatedEntityRegistry ENTITIES = PollinatedEntityRegistry.createEntity(Abundance.MOD_ID);

    public static final Supplier<EntityType<Screecher>> SCREECHER = ENTITIES.register("screecher", () -> EntityType.Builder.of(Screecher::new, MobCategory.MONSTER).sized(1.1F, 1.0F).clientTrackingRange(64).build(Abundance.MOD_ID));

    public static void registerEntityAttributes() {
        EntityAttributeRegistry.register(SCREECHER, Screecher.createScreecherAttributes());
    }
}
