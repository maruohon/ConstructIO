package com.Nitrodev.warehousestorage;

import com.Nitrodev.warehousestorage.blocks.ModBlocks;
import com.Nitrodev.warehousestorage.items.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Jukka on 22.12.2015.
 */
public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModItems.createItems();
        ModBlocks.createBlocks();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e){

    }

    public abstract void registerModels();
}
