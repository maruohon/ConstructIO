package com.Nitrodev.warehousestorage;

import com.Nitrodev.warehousestorage.init.Wsblocks;
import com.Nitrodev.warehousestorage.items.ModItems;
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
