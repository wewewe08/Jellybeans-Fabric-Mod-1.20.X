package net.wewewe.jellybeansmod;

import net.fabricmc.api.ModInitializer;
import net.wewewe.jellybeansmod.Item.ModItemGroups;
import net.wewewe.jellybeansmod.Item.ModItems;
import net.wewewe.jellybeansmod.block.ModBlocks;
import net.wewewe.jellybeansmod.util.ModLootTablesModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JellyBeansMod implements ModInitializer {
	public static final String MOD_ID = "jellybeans-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("jellybeans-mod");

	@Override
	public void onInitialize() {
		ModItems.initialize();

		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		ModLootTablesModifier.modifyLootTables();
	}
}