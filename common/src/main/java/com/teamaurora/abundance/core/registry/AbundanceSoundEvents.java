package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class AbundanceSoundEvents {
    public static final PollinatedRegistry<SoundEvent> SOUND_EVENTS = PollinatedRegistry.create(Registry.SOUND_EVENT, Abundance.MOD_ID);


    public static final Supplier<SoundEvent> SCREECHER_SCREECH = registerSound("screecher_screech");
    public static final Supplier<SoundEvent> SCREECHER_HURT = registerSound("screecher_hurt");
    public static final Supplier<SoundEvent> SCREECHER_DEATH = registerSound("screecher_death");


    private static Supplier<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(Abundance.location(name)));
    }
}
