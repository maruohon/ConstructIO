package com.nitrodev.warehousestorage.proxy;

import com.nitrodev.warehousestorage.init.Wsblocks;
import com.nitrodev.warehousestorage.items.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModItems.createItems();
        Wsblocks.register();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e){

    }

    public abstract void registerModels();
}
