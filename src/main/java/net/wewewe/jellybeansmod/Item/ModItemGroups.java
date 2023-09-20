package net.wewewe.jellybeansmod.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wewewe.jellybeansmod.JellyBeansMod;
import net.wewewe.jellybeansmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup JELLYBEANS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JellyBeansMod.MOD_ID, "jellybeans"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.jellybeans"))
                    .icon(() -> new ItemStack(ModItems.JELLYBEANS)).entries((displayContext, entries) -> {
                        //add items to this group
                        entries.add(ModItems.JELLYBEANS);
                        entries.add(ModBlocks.EMPTY_JAR);
                        entries.add(ModBlocks.JAR_OF_JELLYBEANS);
                    }).build());

    public static void registerItemGroups(){
        JellyBeansMod.LOGGER.info("Registering item groups for " + JellyBeansMod.MOD_ID);
    }
}
