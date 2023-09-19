package net.wewewe.jellybeansmod;

import net.fabricmc.api.ModInitializer;
import net.wewewe.jellybeansmod.Item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JellyBeansMod implements ModInitializer {
	public static final String MOD_ID = "jellybeans-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("jellybeans-mod");

	@Override
	public void onInitialize() {
		ModItems.RegisterModItems();
	}
}