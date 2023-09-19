package net.wewewe.jellybeansmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.wewewe.jellybeansmod.block.ModBlocks;

public class JellyBeansModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EMPTY_JAR, RenderLayer.getCutout());
    }
}
