package com.nitrodev.constructio;

import com.nitrodev.constructio.init.Wsblocks;
import com.nitrodev.constructio.init.Wsitems;
import com.nitrodev.constructio.proxy.CommonProxy;
import com.nitrodev.constructio.recipes.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ConstructIO.MODID, version = ConstructIO.VERSION, name = ConstructIO.NAME)
public class ConstructIO
{
    public static final String MODID = "constructio";
    public static final String VERSION = "1.0";
    public static final String NAME = "ConstructIO";

    @SidedProxy(clientSide = "com.nitrodev.constructio.proxy.ClientProxy", serverSide = "com.nitrodev.constructio.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);

        Wsblocks.registerRenders();
        Wsitems.registerModels();
        ModRecipes.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }
}
