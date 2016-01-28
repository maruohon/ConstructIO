package com.nitrodev.constructio.init;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.blocks.Voider;
import com.nitrodev.constructio.blocks.storage.WoodenCrate;
import com.nitrodev.constructio.blocks.tileentitys.TETWCrate;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cioblocks {

    public static Block voider = new Voider();
    public static Block woodencrate = new WoodenCrate();

    public static void loadTE() {
        GameRegistry.registerTileEntity(TETWCrate.class, "constructio_woodencrate");
    }

    public static void register() {
        GameRegistry.registerBlock(voider, "voider");
        GameRegistry.registerBlock(woodencrate, "woodencrate");
    }

    public static void registerRenders() {
        registerRender(voider, "voider");
        registerRender(woodencrate, "woodencrate");
    }

    private static void registerRender(Block block, String blockName) {
        registerRender(block, 0, blockName);
    }

    private static void registerRender(Block block, int meta, String blockName) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ConstructIO.MODID + ":" + blockName, "inventory"));
    }
}