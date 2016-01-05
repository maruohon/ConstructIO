package com.nitrodev.constructio.proxy;

import com.nitrodev.constructio.init.Cioblocks;
import com.nitrodev.constructio.init.Cioitems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        Cioitems.register();
        Cioblocks.register();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e){

    }
}
