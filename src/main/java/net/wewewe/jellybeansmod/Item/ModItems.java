package net.wewewe.jellybeansmod.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wewewe.jellybeansmod.JellyBeansMod;

public class ModItems {
    //creates a new item in MINECRAFT
    public static final Item JELLYBEANS = RegisterItem("jellybeans", new Item(new FabricItemSettings()));
    private static void AddItemsToFoodTab(FabricItemGroupEntries entries) {
        entries.add(JELLYBEANS);
    }

    //function to register items
    private static Item RegisterItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(JellyBeansMod.MOD_ID, name), item);
    }

    //displays a LOGGER to console
    public static void RegisterModItems() {
        JellyBeansMod.LOGGER.info("Registering mod items for " + JellyBeansMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::AddItemsToFoodTab);
    }
}
