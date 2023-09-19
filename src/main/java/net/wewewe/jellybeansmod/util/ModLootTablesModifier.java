package net.wewewe.jellybeansmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.wewewe.jellybeansmod.Item.ModItems;

public class ModLootTablesModifier {
    private static final String[] HOSTILE_MOBS = {
            "BLAZE", "CAVE_SPIDER", "CREEPER", "DROWNED",
            "ELDER_GUARDIAN", "ENDERMAN", "ENDERMITE", "EVOKER",
            "GHAST", "GUARDIAN", "HUSK", "HOGLIN", "ILLUSIONER",
            "MAGMA_CUBE", "PHANTOM", "PIGLIN", "PIGLIN_BRUTE",
            "PILLAGER", "RAVAGER", "SHULKER", "SKELETON", "SLIME",
            "SPIDER", "STRAY", "STRIDER", "VEX", "VINDICATOR", "WARDEN",
            "WITCH", "WITHER", "WITHER_SKELETON", "ZOGLIN", "ZOMBIE",
            "ZOMBIE_VILLAGER", "ZOMBIFIED_PIGLIN"};

    private static Identifier[] getHostileMobs() {
        int num_mobs = HOSTILE_MOBS.length;
        Identifier[] hostiles = new Identifier[num_mobs];
        for (int i = 0; i < num_mobs; i++) {
            String mob_name = "entities/" + HOSTILE_MOBS[i].toLowerCase();
            hostiles[i] = new Identifier("minecraft", mob_name);
        }
        return hostiles;
    }

    public static void ModifyLootTables(){
        Identifier[] hostiles = getHostileMobs();
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            for (Identifier mob : hostiles) {
                if (mob.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModItems.JELLYBEANS))
                            .rolls(ConstantLootNumberProvider.create(1)) //number of rolls on pool; 1 being constant
                            .conditionally(RandomChanceLootCondition.builder(0.5f)) //drop chance
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)).build()); //number of items dropped (1-3 jellybeans)
                    tableBuilder.pool(poolBuilder.build());
                }
            }
        }));
    }
}
