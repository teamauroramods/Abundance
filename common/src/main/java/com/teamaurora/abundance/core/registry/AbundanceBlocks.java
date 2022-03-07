package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.item.FollowItemLike;
import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.util.Woodset;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class AbundanceBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, Abundance.MOD_ID);

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

    /* Redbud Woodset */

    private static final Woodset REDBUD = new Woodset(MaterialColor.COLOR_LIGHT_GRAY, MaterialColor.COLOR_PURPLE);

    public static final Supplier<Block> STRIPPED_REDBUD_LOG = registerWoodsetBlock("stripped_redbud_log", REDBUD::stripped_log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.STRIPPED_OAK_LOG);
    public static final Supplier<Block> STRIPPED_REDBUD_WOOD = registerWoodsetBlock("stripped_redbud_wood", REDBUD::stripped_wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.STRIPPED_OAK_WOOD);
    public static final Supplier<Block> REDBUD_LOG = registerWoodsetBlock("redbud_log", REDBUD::log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_LOG);
    public static final Supplier<Block> FLOWERING_REDBUD_LOG = registerWoodsetBlock("flowering_redbud_log", REDBUD::log, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_LOG);
    public static final Supplier<Block> REDBUD_WOOD = registerWoodsetBlock("redbud_wood", REDBUD::wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_WOOD);
    public static final Supplier<Block> FLOWERING_REDBUD_WOOD = registerWoodsetBlock("flowering_redbud_wood", REDBUD::wood, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_WOOD);
    public static final Supplier<Block> REDBUD_PLANKS = registerWoodsetBlock("redbud_planks", REDBUD::planks, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_PLANKS);
    public static final Supplier<Block> REDBUD_SLAB = registerWoodsetBlock("redbud_slab", REDBUD::slab, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_SLAB);
    public static final Supplier<Block> REDBUD_STAIRS = registerWoodsetBlock("redbud_stairs", () -> REDBUD.stairs(REDBUD_PLANKS), CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.OAK_STAIRS);
    public static final Supplier<Block> REDBUD_PRESSURE_PLATE = registerWoodsetBlock("redbud_pressure_plate", REDBUD::pressurePlate, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_PRESSURE_PLATE);
    public static final Supplier<Block> REDBUD_BUTTON = registerWoodsetBlock("redbud_button", REDBUD::button, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_BUTTON);
    public static final Supplier<Block> REDBUD_FENCE = registerWoodsetBlock("redbud_fence", REDBUD::fence, CreativeModeTab.TAB_DECORATIONS, Blocks.OAK_FENCE);
    public static final Supplier<Block> REDBUD_FENCE_GATE = registerWoodsetBlock("redbud_fence_gate", REDBUD::fenceGate, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_FENCE_GATE);
    public static final Supplier<Block> REDBUD_DOOR = registerWoodsetBlock("redbud_door", REDBUD::door, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_DOOR);
    public static final Supplier<Block> REDBUD_TRAPDOOR = registerWoodsetBlock("redbud_trapdoor", REDBUD::trapdoor, CreativeModeTab.TAB_REDSTONE, Blocks.OAK_TRAPDOOR);


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
}
