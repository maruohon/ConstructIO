package com.Nitrodev.warehousestorage;

import com.Nitrodev.warehousestorage.items.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Jukka on 22.12.2015.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModItems.createItems();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e){

    }
}
