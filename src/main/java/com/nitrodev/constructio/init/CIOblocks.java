package com.nitrodev.constructio.init;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.blocks.BlockConstructor;
import com.nitrodev.constructio.blocks.Voider;
import com.nitrodev.constructio.blocks.storage.TECrateMaster;
import com.nitrodev.constructio.blocks.storage.WoodenCrate;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cioblocks {

    public static Block voider = new Voider();
    public static Block constructor = new BlockConstructor();
    //public static Block woodenct = new Wooden();
    public static Block woodencrate = new WoodenCrate();

    public static void loadTE() {
        //GameRegistry.registerTileEntity(TileConstructor.class, "constructio_constructor");
        GameRegistry.registerTileEntity(TECrateMaster.class, "constructio_woodencrate");
    }

    public static void register() {
        GameRegistry.registerBlock(voider, "voider");
        //GameRegistry.registerBlock(constructor, "constructor");
        //GameRegistry.registerBlock(woodenct, "woodenCt");
        GameRegistry.registerBlock(woodencrate, "woodenCrate");
    }

    public static void registerRenders() {
        registerRender(voider, "voider");
        registerRender(woodencrate, "woodenCrate");
    }

    private static void registerRender(Block block, String blockName) {
        registerRender(block, 0, blockName);
    }

    private static void registerRender(Block block, int meta, String blockName) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ConstructIO.MODID + ":" + blockName, "inventory"));
    }
}
