package com.Nitrodev.warehousestorage.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static Block voider = new Voider("blockVoider");

    public static void createBlocks() {
        GameRegistry.registerBlock(voider, "blockVoider");
    }
}
