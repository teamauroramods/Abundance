package com.teamaurora.abundance.core;

import gg.moonflower.pollen.api.config.PollinatedConfigBuilder;
import gg.moonflower.pollen.api.config.PollinatedConfigBuilder.ConfigValue;

import java.util.ArrayList;

public class AbundanceCommonConfig {
    public final ConfigValue<Boolean> replace_jungle_grass;
    public final ConfigValue<Boolean> enable_meadow_enhancements;
    public final ConfigValue<ArrayList<String>> redbud_spawn_biomes;
    public final ConfigValue<ArrayList<String>> thunbergia_spawn_biomes;

    protected AbundanceCommonConfig(PollinatedConfigBuilder builder) {
        builder.push("Abundance");
        {
            ArrayList<String> defaultRedbudBiomes = new ArrayList<>();
            ArrayList<String> defaultThunbergiaBiomes = new ArrayList<>();

            defaultRedbudBiomes.add("minecraft:forest");
            defaultRedbudBiomes.add("minecraft:plains");
            defaultRedbudBiomes.add("minecraft:flower_forest");

            defaultThunbergiaBiomes.add("minecraft:jungle");
            defaultThunbergiaBiomes.add("minecraft:sparse_jungle");

            this.replace_jungle_grass = builder.comment("Whether tropical grass & ferns should replace their normal variants in tropical biomes.").define("Replace Jungle Grass", true);
            this.enable_meadow_enhancements = builder.comment("Whether vanilla meadows should generate with custom features (Blue Jacarandas, Nemophilas, and Blue Daisies).").define("Enable Meadow Enhancements", true);
            this.redbud_spawn_biomes = builder.comment("Defines which biomes Redbud trees can spawn in.").define("Redbud Spawn Biomes", defaultRedbudBiomes);
            this.thunbergia_spawn_biomes = builder.comment("Defines which biomes Thunbergia Jungle trees can spawn in.").define("Thunbergia Spawn Biomes", defaultThunbergiaBiomes);
        }
        builder.pop();
    }
}
