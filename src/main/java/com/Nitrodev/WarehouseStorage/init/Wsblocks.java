package com.nitrodev.warehousestorage.init;

import com.nitrodev.warehousestorage.WarehouseStorage;
import com.nitrodev.warehousestorage.blocks.Voider;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Wsblocks {

    public static Block voider = new Voider();

    public static void register() {
        GameRegistry.registerBlock(voider, "voider");
    }

    public static void registerRenders() {
        registerRender(voider, "voider");
    }

    private static void registerRender(Block block, String blockName) {
        registerRender(block, 0, blockName);
    }

    private static void registerRender(Block block, int meta, String blockName) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(WarehouseStorage.MODID + ":" + blockName, "inventory"));
    }
}
