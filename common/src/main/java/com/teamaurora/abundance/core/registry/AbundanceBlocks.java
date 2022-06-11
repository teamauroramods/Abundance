package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.block.*;
import com.teamaurora.abundance.common.block.woodset.Woodset;
import com.teamaurora.abundance.common.item.TabInsertBlockItem;
import gg.moonflower.pollen.api.registry.PollinatedBlockRegistry;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class AbundanceBlocks {
    public static final PollinatedBlockRegistry BLOCKS = PollinatedRegistry.createBlock(AbundanceItems.ITEMS);

    /* Lavender */

    public static final Supplier<Block> LAVENDER = BLOCKS.register("lavender", () -> new LavenderBlock(Properties.LAVENDER));
    public static final Supplier<Block> TALL_LAVENDER = BLOCKS.register("tall_lavender", () -> new TallLavenderBlock(Properties.LAVENDER));


    /* Marigolds */

    public static final Supplier<Block> SMALL_MARIGOLD = BLOCKS.registerWithItem("small_marigold", () -> new SmallMarigoldBlock(() -> MobEffects.HEAL, 1, Properties.YELLOW_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> SUNNY_MARIGOLD = BLOCKS.registerWithItem("sunny_marigold", () -> new MarigoldBlock(() -> MobEffects.HEAL, 1, Properties.YELLOW_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> SHADY_MARIGOLD = BLOCKS.registerWithItem("shady_marigold", () -> new MarigoldBlock(() ->MobEffects.HEAL, 1, Properties.YELLOW_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> TALL_MARIGOLD = BLOCKS.registerWithItem("tall_marigold", () -> new TallMarigoldBlock(Properties.YELLOW_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_SMALL_MARIGOLD = BLOCKS.register("potted_small_marigold", createFlowerPot(SMALL_MARIGOLD));
    public static final Supplier<Block> POTTED_SUNNY_MARIGOLD = BLOCKS.register("potted_sunny_marigold", createFlowerPot(SUNNY_MARIGOLD));
    public static final Supplier<Block> POTTED_SHADY_MARIGOLD = BLOCKS.register("potted_shady_marigold", createFlowerPot(SHADY_MARIGOLD));


    /* Jacaranda Woodset */

    private static final Woodset JACARANDA = new Woodset(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_PURPLE);

    public static final Supplier<Block> STRIPPED_JACARANDA_LOG = BLOCKS.registerWithItem("stripped_jacaranda_log", JACARANDA::stripped_log, followItem(Items.STRIPPED_WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> STRIPPED_JACARANDA_WOOD = BLOCKS.registerWithItem("stripped_jacaranda_wood", JACARANDA::stripped_wood, followItem(Items.STRIPPED_WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> JACARANDA_LOG = BLOCKS.registerWithItem("jacaranda_log", JACARANDA::log, followItem(Items.WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> JACARANDA_WOOD = BLOCKS.registerWithItem("jacaranda_wood", JACARANDA::wood, followItem(Items.WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> JACARANDA_PLANKS = BLOCKS.registerWithItem("jacaranda_planks", JACARANDA::planks, followItem(Items.WARPED_PLANKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> JACARANDA_SLAB = BLOCKS.registerWithItem("jacaranda_slab", JACARANDA::slab, followItem(Items.WARPED_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> JACARANDA_STAIRS = BLOCKS.registerWithItem("jacaranda_stairs", () -> JACARANDA.stairs(JACARANDA_PLANKS), followItem(Items.WARPED_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> JACARANDA_PRESSURE_PLATE = BLOCKS.registerWithItem("jacaranda_pressure_plate", JACARANDA::pressurePlate, followItem(Items.WARPED_PRESSURE_PLATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> JACARANDA_BUTTON = BLOCKS.registerWithItem("jacaranda_button", JACARANDA::button, followItem(Items.WARPED_BUTTON, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> JACARANDA_FENCE = BLOCKS.registerWithItem("jacaranda_fence", JACARANDA::fence, followItem(Items.WARPED_FENCE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> JACARANDA_FENCE_GATE = BLOCKS.registerWithItem("jacaranda_fence_gate", JACARANDA::fenceGate, followItem(Items.WARPED_FENCE_GATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> JACARANDA_DOOR = BLOCKS.registerWithItem("jacaranda_door", JACARANDA::door, followItem(Items.WARPED_DOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> JACARANDA_TRAPDOOR = BLOCKS.registerWithItem("jacaranda_trapdoor", JACARANDA::trapdoor, followItem(Items.WARPED_TRAPDOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final Supplier<Block> JACARANDA_LEAVES = BLOCKS.registerWithItem("jacaranda_leaves", () -> new LeavesBlock(Properties.JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BUDDING_JACARANDA_LEAVES = BLOCKS.registerWithItem("budding_jacaranda_leaves", () -> new LeavesBlock(Properties.JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_JACARANDA_LEAVES = BLOCKS.registerWithItem("flowering_jacaranda_leaves", () -> new LeavesBlock(Properties.JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> JACARANDA_SAPLING = BLOCKS.registerWithItem("jacaranda_sapling", () -> new SaplingBlock(new OakTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> BLUE_JACARANDA_LEAVES = BLOCKS.registerWithItem("blue_jacaranda_leaves", () -> new LeavesBlock(Properties.BLUE_JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BUDDING_BLUE_JACARANDA_LEAVES = BLOCKS.registerWithItem("budding_blue_jacaranda_leaves", () -> new LeavesBlock(Properties.BLUE_JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_BLUE_JACARANDA_LEAVES = BLOCKS.registerWithItem("flowering_blue_jacaranda_leaves", () -> new LeavesBlock(Properties.BLUE_JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BLUE_JACARANDA_SAPLING = BLOCKS.registerWithItem("blue_jacaranda_sapling", () -> new SaplingBlock(new OakTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_JACARANDA_SAPLING = BLOCKS.register("potted_jacaranda_sapling", createFlowerPot(JACARANDA_SAPLING));
    public static final Supplier<Block> POTTED_BLUE_JACARANDA_SAPLING = BLOCKS.register("potted_blue_jacaranda_sapling", createFlowerPot(BLUE_JACARANDA_SAPLING));


    /* Redbud Woodset */

    private static final Woodset REDBUD = new Woodset(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_PURPLE);

    public static final Supplier<Block> STRIPPED_REDBUD_LOG = BLOCKS.registerWithItem("stripped_redbud_log", REDBUD::stripped_log, followItem(Items.STRIPPED_WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> STRIPPED_REDBUD_WOOD = BLOCKS.registerWithItem("stripped_redbud_wood", REDBUD::stripped_wood, followItem(Items.STRIPPED_WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> REDBUD_LOG = BLOCKS.registerWithItem("redbud_log", REDBUD::log, followItem(Items.WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> FLOWERING_REDBUD_LOG = BLOCKS.registerWithItem("flowering_redbud_log", REDBUD::flowering_log, followItem(Items.WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> REDBUD_WOOD = BLOCKS.registerWithItem("redbud_wood", REDBUD::wood, followItem(Items.WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> FLOWERING_REDBUD_WOOD = BLOCKS.registerWithItem("flowering_redbud_wood", REDBUD::flowering_wood, followItem(Items.WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> REDBUD_PLANKS = BLOCKS.registerWithItem("redbud_planks", REDBUD::planks, followItem(Items.WARPED_PLANKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> REDBUD_SLAB = BLOCKS.registerWithItem("redbud_slab", REDBUD::slab, followItem(Items.WARPED_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> REDBUD_STAIRS = BLOCKS.registerWithItem("redbud_stairs", () -> REDBUD.stairs(REDBUD_PLANKS), followItem(Items.WARPED_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> REDBUD_PRESSURE_PLATE = BLOCKS.registerWithItem("redbud_pressure_plate", REDBUD::pressurePlate, followItem(Items.WARPED_PRESSURE_PLATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> REDBUD_BUTTON = BLOCKS.registerWithItem("redbud_button", REDBUD::button, followItem(Items.WARPED_BUTTON, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> REDBUD_FENCE = BLOCKS.registerWithItem("redbud_fence", REDBUD::fence, followItem(Items.WARPED_FENCE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> REDBUD_FENCE_GATE = BLOCKS.registerWithItem("redbud_fence_gate", REDBUD::fenceGate, followItem(Items.WARPED_FENCE_GATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> REDBUD_DOOR = BLOCKS.registerWithItem("redbud_door", REDBUD::door, followItem(Items.WARPED_DOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> REDBUD_TRAPDOOR = BLOCKS.registerWithItem("redbud_trapdoor", REDBUD::trapdoor, followItem(Items.WARPED_TRAPDOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final Supplier<Block> REDBUD_LEAVES = BLOCKS.registerWithItem("redbud_leaves", () -> new LeavesBlock(Properties.REDBUD_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BUDDING_REDBUD_LEAVES = BLOCKS.registerWithItem("budding_redbud_leaves", () -> new LeavesBlock(Properties.REDBUD_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_REDBUD_LEAVES = BLOCKS.registerWithItem("flowering_redbud_leaves", () -> new LeavesBlock(Properties.REDBUD_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> REDBUD_SAPLING = BLOCKS.registerWithItem("redbud_sapling", () -> new SaplingBlock(new OakTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_REDBUD_SAPLING = BLOCKS.registerWithItem("flowering_redbud_sapling", () -> new SaplingBlock(new OakTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_REDBUD_SAPLING = BLOCKS.register("potted_redbud_sapling", createFlowerPot(REDBUD_SAPLING));
    public static final Supplier<Block> POTTED_FLOWERING_REDBUD_SAPLING = BLOCKS.register("potted_flowering_redbud_sapling", createFlowerPot(FLOWERING_REDBUD_SAPLING));

    public static final Supplier<Block> PINK_BLOSSOM_CARPET = BLOCKS.registerWithItem("pink_blossom_carpet", () -> new BlossomCarpetBlock(Properties.PINK_BLOSSOM_CARPET), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));


    /* Thunbergia Blocks */

    public static final Supplier<Block> THUNBERGIA_VINE = BLOCKS.registerWithItem("thunbergia_vine", () -> new VineBlock(Properties.VINE), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> THUNBERGIA_JUNGLE_LEAVES = BLOCKS.registerWithItem("thunbergia_jungle_leaves", () -> new LeavesBlock(Properties.THUNBERGIA_JUNGLE_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));


    /* Daisies */

    public static final Supplier<Block> PINK_DAISY = BLOCKS.registerWithItem("pink_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> PURPLE_DAISY = BLOCKS.registerWithItem("purple_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> MAGENTA_DAISY = BLOCKS.registerWithItem("magenta_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> YELLOW_DAISY = BLOCKS.registerWithItem("yellow_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> ORANGE_DAISY = BLOCKS.registerWithItem("orange_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> RED_DAISY = BLOCKS.registerWithItem("red_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BLUE_DAISY = BLOCKS.registerWithItem("blue_daisy", () -> new AbundanceFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_PINK_DAISY = BLOCKS.register("potted_pink_daisy", createFlowerPot(PINK_DAISY));
    public static final Supplier<Block> POTTED_PURPLE_DAISY = BLOCKS.register("potted_purple_daisy", createFlowerPot(PURPLE_DAISY));
    public static final Supplier<Block> POTTED_MAGENTA_DAISY = BLOCKS.register("potted_magenta_daisy", createFlowerPot(MAGENTA_DAISY));
    public static final Supplier<Block> POTTED_YELLOW_DAISY = BLOCKS.register("potted_yellow_daisy", createFlowerPot(YELLOW_DAISY));
    public static final Supplier<Block> POTTED_ORANGE_DAISY = BLOCKS.register("potted_orange_daisy", createFlowerPot(ORANGE_DAISY));
    public static final Supplier<Block> POTTED_RED_DAISY = BLOCKS.register("potted_red_daisy", createFlowerPot(RED_DAISY));
    public static final Supplier<Block> POTTED_BLUE_DAISY = BLOCKS.register("potted_blue_daisy", createFlowerPot(BLUE_DAISY));


    /* Other Random Flowers */

    public static final Supplier<Block> CHICORY = BLOCKS.registerWithItem("chicory", () -> new ChicoryBlock(MobEffects.DIG_SPEED, 5, Properties.BLUE_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> CHICORY_COLONY = BLOCKS.registerWithItem("chicory_colony", () -> new BushBlock(Properties.CHICORY_COLONY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> AMARANTHUS = BLOCKS.registerWithItem("amaranthus", () -> new ModifiedFlowerBlock(() -> MobEffects.HUNGER, 6, Properties.AMARANTHUS), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> NEMOPHILA = BLOCKS.registerWithItem("nemophila", () -> new NemophilaBlock(() -> MobEffects.MOVEMENT_SPEED, 8, Properties.BLUE_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> MYOSOTIS = BLOCKS.registerWithItem("myosotis", () -> new AbundanceFlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 8, Properties.BLUE_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FIDDLENECK = BLOCKS.registerWithItem("fiddleneck", () -> new AbundanceFlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 8, Properties.YELLOW_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> HELICONIA = BLOCKS.registerWithItem("heliconia", () -> new TallFlowerBlock(Properties.HELICONIA), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> BEGONIA = BLOCKS.registerWithItem("begonia", () -> new ModifiedFlowerBlock(() -> MobEffects.DAMAGE_RESISTANCE, 6, Properties.DAISY), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> CARNATION = BLOCKS.registerWithItem("carnation", () -> new ModifiedFlowerBlock(() -> MobEffects.DAMAGE_RESISTANCE, 6, Properties.RED_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> CHRYSANTHEMUM = BLOCKS.registerWithItem("chrysanthemum", () -> new ModifiedFlowerBlock(() -> MobEffects.REGENERATION, 8, Properties.YELLOW_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> DIANTHUS = BLOCKS.registerWithItem("dianthus", () -> new ModifiedFlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 8, Properties.PINK_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> HEATHER = BLOCKS.registerWithItem("heather", () -> new ModifiedFlowerBlock(() -> MobEffects.LUCK, 16, Properties.PURPLE_FLOWER), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_CHICORY = BLOCKS.register("potted_chicory", createFlowerPot(CHICORY));
    public static final Supplier<Block> POTTED_AMARANTHUS = BLOCKS.register("potted_amaranthus", createFlowerPot(AMARANTHUS));
    public static final Supplier<Block> POTTED_NEMOPHILA = BLOCKS.register("potted_nemophila", createFlowerPot(NEMOPHILA));
    public static final Supplier<Block> POTTED_MYOSOTIS = BLOCKS.register("potted_myosotis", createFlowerPot(MYOSOTIS));
    public static final Supplier<Block> POTTED_FIDDLENECK = BLOCKS.register("potted_fiddleneck", createFlowerPot(FIDDLENECK));

    public static final Supplier<Block> POTTED_BEGONIA = BLOCKS.register("potted_begonia", createFlowerPot(BEGONIA));
    public static final Supplier<Block> POTTED_CARNATION = BLOCKS.register("potted_carnation", createFlowerPot(CARNATION));
    public static final Supplier<Block> POTTED_CHRYSANTHEMUM = BLOCKS.register("potted_chrysanthemum", createFlowerPot(CHRYSANTHEMUM));
    public static final Supplier<Block> POTTED_DIANTHUS = BLOCKS.register("potted_dianthus", createFlowerPot(DIANTHUS));
    public static final Supplier<Block> POTTED_HEATHER = BLOCKS.register("potted_heather", createFlowerPot(HEATHER));

    /* Tropical Foliage */

    public static final Supplier<Block> TROPICAL_GRASS = BLOCKS.registerWithItem("tropical_grass", () -> new TallGrassBlock(Properties.GRASS), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> TROPICAL_FERN = BLOCKS.registerWithItem("tropical_fern", () -> new TallGrassBlock(Properties.GRASS), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    private static Supplier<Block> createFlowerPot(Supplier<Block> block) {
        return () -> new FlowerPotBlock(block.get(), Properties.POTTED_PLANT);
    }

    private static Function<Block, Item> followItem(Item insertAfter, Item.Properties properties) {
        return object -> new TabInsertBlockItem(insertAfter, object, properties);
    }

    public static final class Properties {
        public static final BlockBehaviour.Properties LAVENDER = BlockBehaviour.Properties.copy(Blocks.ALLIUM).sound(SoundType.CROP);
        public static final BlockBehaviour.Properties JACARANDA_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_PURPLE);
        public static final BlockBehaviour.Properties BLUE_JACARANDA_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_LIGHT_BLUE);
        public static final BlockBehaviour.Properties THUNBERGIA_JUNGLE_LEAVES = BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES).color(MaterialColor.COLOR_YELLOW);
        public static final BlockBehaviour.Properties VINE = BlockBehaviour.Properties.copy(Blocks.VINE);
        public static final BlockBehaviour.Properties REDBUD_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_RED);
        public static final BlockBehaviour.Properties SAPLING = BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING);
        public static final BlockBehaviour.Properties POTTED_PLANT = BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM);
        public static final BlockBehaviour.Properties PINK_BLOSSOM_CARPET = BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_PINK).noOcclusion().instabreak().randomTicks().sound(SoundType.AZALEA_LEAVES);
        public static final BlockBehaviour.Properties DAISY = BlockBehaviour.Properties.copy(Blocks.OXEYE_DAISY);
        public static final BlockBehaviour.Properties BLUE_FLOWER = BlockBehaviour.Properties.copy(Blocks.CORNFLOWER);
        public static final BlockBehaviour.Properties CHICORY = BlockBehaviour.Properties.copy(Blocks.ALLIUM);
        public static final BlockBehaviour.Properties CHICORY_COLONY = BlockBehaviour.Properties.copy(Blocks.ALLIUM).sound(SoundType.CROP);
        public static final BlockBehaviour.Properties AMARANTHUS = BlockBehaviour.Properties.copy(Blocks.POPPY);
        public static final BlockBehaviour.Properties YELLOW_FLOWER = BlockBehaviour.Properties.copy(Blocks.DANDELION);
        public static final BlockBehaviour.Properties RED_FLOWER = BlockBehaviour.Properties.copy(Blocks.POPPY);
        public static final BlockBehaviour.Properties HELICONIA = BlockBehaviour.Properties.copy(Blocks.PEONY);
        public static final BlockBehaviour.Properties GRASS = BlockBehaviour.Properties.copy(Blocks.GRASS);
        public static final BlockBehaviour.Properties FERN = BlockBehaviour.Properties.copy(Blocks.FERN);
        public static final BlockBehaviour.Properties PINK_FLOWER = RED_FLOWER.color(MaterialColor.COLOR_PINK);
        public static final BlockBehaviour.Properties PURPLE_FLOWER = BlockBehaviour.Properties.copy(Blocks.ALLIUM);
    }
}
