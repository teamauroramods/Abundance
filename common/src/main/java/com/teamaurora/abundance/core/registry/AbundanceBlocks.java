package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.block.BlossomCarpetBlock;
import com.teamaurora.abundance.common.block.LavenderBlock;
import com.teamaurora.abundance.common.block.TallLavenderBlock;
import com.teamaurora.abundance.common.block.trees.BlueJacarandaTreeGrower;
import com.teamaurora.abundance.common.block.trees.FloweringRedbudTreeGrower;
import com.teamaurora.abundance.common.block.trees.JacarandaTreeGrower;
import com.teamaurora.abundance.common.block.trees.RedbudTreeGrower;
import com.teamaurora.abundance.common.item.FollowItemLike;
import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.util.Woodset;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class AbundanceBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, Abundance.MOD_ID);

    /* Lavender */

    public static final Supplier<Block> LAVENDER = registerBlockNoItem("lavender", () -> new LavenderBlock(Properties.LAVENDER));
    public static final Supplier<Block> TALL_LAVENDER = registerBlockNoItem("tall_lavender", () -> new TallLavenderBlock(Properties.LAVENDER));

    /* Jacaranda Woodset */

    private static final Woodset JACARANDA = new Woodset(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_PURPLE);

    public static final Supplier<Block> STRIPPED_JACARANDA_LOG = registerWoodsetBlock("stripped_jacaranda_log", JACARANDA::stripped_log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.STRIPPED_OAK_LOG);
    public static final Supplier<Block> STRIPPED_JACARANDA_WOOD = registerWoodsetBlock("stripped_jacaranda_wood", JACARANDA::stripped_wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.STRIPPED_OAK_WOOD);
    public static final Supplier<Block> JACARANDA_LOG = registerWoodsetBlock("jacaranda_log", JACARANDA::log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_LOG);
    public static final Supplier<Block> JACARANDA_WOOD = registerWoodsetBlock("jacaranda_wood", JACARANDA::wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_WOOD);
    public static final Supplier<Block> JACARANDA_PLANKS = registerWoodsetBlock("jacaranda_planks", JACARANDA::planks, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_PLANKS);
    public static final Supplier<Block> JACARANDA_SLAB = registerWoodsetBlock("jacaranda_slab", JACARANDA::slab, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_SLAB);
    public static final Supplier<Block> JACARANDA_STAIRS = registerWoodsetBlock("jacaranda_stairs", () -> JACARANDA.stairs(JACARANDA_PLANKS), CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_STAIRS);
    public static final Supplier<Block> JACARANDA_PRESSURE_PLATE = registerWoodsetBlock("jacaranda_pressure_plate", JACARANDA::pressurePlate, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_PRESSURE_PLATE);
    public static final Supplier<Block> JACARANDA_BUTTON = registerWoodsetBlock("jacaranda_button", JACARANDA::button, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_BUTTON);
    public static final Supplier<Block> JACARANDA_FENCE = registerWoodsetBlock("jacaranda_fence", JACARANDA::fence, CreativeModeTab.TAB_DECORATIONS, Blocks.OAK_FENCE);
    public static final Supplier<Block> JACARANDA_FENCE_GATE = registerWoodsetBlock("jacaranda_fence_gate", JACARANDA::fenceGate, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_FENCE_GATE);
    public static final Supplier<Block> JACARANDA_DOOR = registerWoodsetBlock("jacaranda_door", JACARANDA::door, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_DOOR);
    public static final Supplier<Block> JACARANDA_TRAPDOOR = registerWoodsetBlock("jacaranda_trapdoor", JACARANDA::trapdoor, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_TRAPDOOR);

    public static final Supplier<Block> JACARANDA_LEAVES = registerBlock("jacaranda_leaves", () -> new LeavesBlock(Properties.JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BUDDING_JACARANDA_LEAVES = registerBlock("budding_jacaranda_leaves", () -> new LeavesBlock(Properties.JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_JACARANDA_LEAVES = registerBlock("flowering_jacaranda_leaves", () -> new LeavesBlock(Properties.JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> JACARANDA_SAPLING = registerBlock("jacaranda_sapling", () -> new SaplingBlock(new JacarandaTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> BLUE_JACARANDA_LEAVES = registerBlock("blue_jacaranda_leaves", () -> new LeavesBlock(Properties.BLUE_JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BUDDING_BLUE_JACARANDA_LEAVES = registerBlock("budding_blue_jacaranda_leaves", () -> new LeavesBlock(Properties.BLUE_JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_BLUE_JACARANDA_LEAVES = registerBlock("flowering_blue_jacaranda_leaves", () -> new LeavesBlock(Properties.BLUE_JACARANDA_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BLUE_JACARANDA_SAPLING = registerBlock("blue_jacaranda_sapling", () -> new SaplingBlock(new BlueJacarandaTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_JACARANDA_SAPLING = registerPotted("potted_jacaranda_sapling", JACARANDA_SAPLING);
    public static final Supplier<Block> POTTED_BLUE_JACARANDA_SAPLING = registerPotted("potted_blue_jacaranda_sapling", BLUE_JACARANDA_SAPLING);


    /* Redbud Woodset */

    private static final Woodset REDBUD = new Woodset(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_PURPLE);

    public static final Supplier<Block> STRIPPED_REDBUD_LOG = registerWoodsetBlock("stripped_redbud_log", REDBUD::stripped_log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.STRIPPED_OAK_LOG);
    public static final Supplier<Block> STRIPPED_REDBUD_WOOD = registerWoodsetBlock("stripped_redbud_wood", REDBUD::stripped_wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.STRIPPED_OAK_WOOD);
    public static final Supplier<Block> REDBUD_LOG = registerWoodsetBlock("redbud_log", REDBUD::log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_LOG);
    public static final Supplier<Block> FLOWERING_REDBUD_LOG = registerWoodsetBlock("flowering_redbud_log", REDBUD::flowering_log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_LOG);
    public static final Supplier<Block> REDBUD_WOOD = registerWoodsetBlock("redbud_wood", REDBUD::wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_WOOD);
    public static final Supplier<Block> FLOWERING_REDBUD_WOOD = registerWoodsetBlock("flowering_redbud_wood", REDBUD::flowering_wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_WOOD);
    public static final Supplier<Block> REDBUD_PLANKS = registerWoodsetBlock("redbud_planks", REDBUD::planks, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_PLANKS);
    public static final Supplier<Block> REDBUD_SLAB = registerWoodsetBlock("redbud_slab", REDBUD::slab, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_SLAB);
    public static final Supplier<Block> REDBUD_STAIRS = registerWoodsetBlock("redbud_stairs", () -> REDBUD.stairs(REDBUD_PLANKS), CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_STAIRS);
    public static final Supplier<Block> REDBUD_PRESSURE_PLATE = registerWoodsetBlock("redbud_pressure_plate", REDBUD::pressurePlate, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_PRESSURE_PLATE);
    public static final Supplier<Block> REDBUD_BUTTON = registerWoodsetBlock("redbud_button", REDBUD::button, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_BUTTON);
    public static final Supplier<Block> REDBUD_FENCE = registerWoodsetBlock("redbud_fence", REDBUD::fence, CreativeModeTab.TAB_DECORATIONS, Blocks.OAK_FENCE);
    public static final Supplier<Block> REDBUD_FENCE_GATE = registerWoodsetBlock("redbud_fence_gate", REDBUD::fenceGate, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_FENCE_GATE);
    public static final Supplier<Block> REDBUD_DOOR = registerWoodsetBlock("redbud_door", REDBUD::door, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_DOOR);
    public static final Supplier<Block> REDBUD_TRAPDOOR = registerWoodsetBlock("redbud_trapdoor", REDBUD::trapdoor, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_TRAPDOOR);

    public static final Supplier<Block> REDBUD_LEAVES = registerBlock("redbud_leaves", () -> new LeavesBlock(Properties.REDBUD_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> BUDDING_REDBUD_LEAVES = registerBlock("budding_redbud_leaves", () -> new LeavesBlock(Properties.REDBUD_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_REDBUD_LEAVES = registerBlock("flowering_redbud_leaves", () -> new LeavesBlock(Properties.REDBUD_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> REDBUD_SAPLING = registerBlock("redbud_sapling", () -> new SaplingBlock(new RedbudTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> FLOWERING_REDBUD_SAPLING = registerBlock("flowering_redbud_sapling", () -> new SaplingBlock(new FloweringRedbudTreeGrower(), Properties.SAPLING), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> POTTED_REDBUD_SAPLING = registerPotted("potted_redbud_sapling", REDBUD_SAPLING);
    public static final Supplier<Block> POTTED_FLOWERING_REDBUD_SAPLING = registerPotted("potted_flowering_redbud_sapling", FLOWERING_REDBUD_SAPLING);

    /* Tunbergia Blocks */

    public static final Supplier<Block> THUNBERGIA_VINE = registerBlock("thunbergia_vine", () -> new VineBlock(Properties.VINE), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> THUNBERGIA_JUNGLE_LEAVES = registerBlock("thunbergia_jungle_leaves", () -> new LeavesBlock(Properties.TUNBERGIA_JUNGLE_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    /* Misc */

    public static final Supplier<Block> PINK_BLOSSOM_CARPET = registerBlock("pink_blossom_carpet", () -> new BlossomCarpetBlock(Properties.PINK_BLOSSOM_CARPET), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    private static Supplier<Block> registerBlock(String id, Supplier<Block> block, Item.Properties properties) {
        Supplier<Block> register = BLOCKS.register(id, block);
        AbundanceItems.ITEMS.register(id, () -> new BlockItem(register.get(), properties));
        return register;
    }

    private static Supplier<Block> registerBlockNoItem(String id, Supplier<Block> block) {
        Supplier<Block> register = BLOCKS.register(id, block);
        return register;
    }

    private static Supplier<Block> registerWoodsetBlock(String id, Supplier<Block> block, CreativeModeTab tab, Block followBlock) {
        Supplier<Block> register = BLOCKS.register(id, block);
        AbundanceItems.ITEMS.register(id, () -> new FollowItemLike(register.get(), new Item.Properties(), tab, followBlock));
        return register;
    }

    private static Supplier<Block> registerPotted(String id, Supplier<Block> block) {
        Supplier<Block> register = BLOCKS.register(id, () -> new FlowerPotBlock(block.get(), Properties.POTTED_PLANT));
        return register;
    }

    public static final class Properties {
        public static final BlockBehaviour.Properties LAVENDER = BlockBehaviour.Properties.copy(Blocks.ALLIUM).sound(SoundType.CROP);
        public static final BlockBehaviour.Properties JACARANDA_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_PURPLE);
        public static final BlockBehaviour.Properties BLUE_JACARANDA_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_LIGHT_BLUE);
        public static final BlockBehaviour.Properties TUNBERGIA_JUNGLE_LEAVES = BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES).color(MaterialColor.COLOR_YELLOW);
        public static final BlockBehaviour.Properties VINE = BlockBehaviour.Properties.copy(Blocks.VINE);
        public static final BlockBehaviour.Properties REDBUD_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_RED);
        public static final BlockBehaviour.Properties SAPLING = BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING);
        public static final BlockBehaviour.Properties POTTED_PLANT = BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM);
        public static final BlockBehaviour.Properties PINK_BLOSSOM_CARPET = BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_PINK).noOcclusion().instabreak().randomTicks().sound(SoundType.AZALEA_LEAVES);
    }

}
