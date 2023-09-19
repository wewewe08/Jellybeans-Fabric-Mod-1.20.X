package net.wewewe.jellybeansmod.Item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wewewe.jellybeansmod.JellyBeansMod;

public class ModItems {
    public static <T extends Item> T register(T item, String ID) {
        Identifier jellybeansID = new Identifier(JellyBeansMod.MOD_ID, ID); //creates identifier for item
        return Registry.register(Registries.ITEM, jellybeansID, item);
    }

    //creates a new food item in MINECRAFT
    public static final Item JELLYBEANS = register(new Item(new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .snack()
            .build())), "jellybeans");

    public static void initialize() {
        JellyBeansMod.LOGGER.info("Registering items to " + JellyBeansMod.MOD_ID);
    }
}
