package net.wewewe.jellybeansmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.wewewe.jellybeansmod.JellyBeansMod;
import net.wewewe.jellybeansmod.block.custom.Empty_Jar;

public class ModBlocks {
    public static final Block EMPTY_JAR = registerBlock("empty_jar",
            new Empty_Jar(FabricBlockSettings.copyOf(Blocks.FLOWER_POT).sounds(BlockSoundGroup.GLASS)));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(JellyBeansMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(JellyBeansMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        JellyBeansMod.LOGGER.info("Registered blocks for " + JellyBeansMod.MOD_ID);
    }
}
