package com.Nitrodev.warehousestorage.init;

import com.Nitrodev.warehousestorage.WarehouseStorage;
import com.Nitrodev.warehousestorage.blocks.Voider;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
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
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(WarehouseStorage.MODID + ":" + blockName, "inventory"));
    }
}
