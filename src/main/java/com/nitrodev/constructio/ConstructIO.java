package com.nitrodev.constructio;

import com.nitrodev.constructio.gui.GuiHandler;
import com.nitrodev.constructio.init.Cioblocks;
import com.nitrodev.constructio.init.Cioitems;
import com.nitrodev.constructio.proxy.CommonProxy;
import com.nitrodev.constructio.recipes.ModRecipes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = ConstructIO.MODID, version = ConstructIO.VERSION, name = ConstructIO.NAME)
public class ConstructIO
{
    public static final String MODID = "constructio";
    public static final String VERSION = "1.0";
    public static final String NAME = "ConstructIO";
    public static final ConstructioTab tabconstructio = new ConstructioTab("tabConstructio");

    @Mod.Instance(value = ConstructIO.MODID)
    public static ConstructIO instance;

    @SidedProxy(clientSide = "com.nitrodev.constructio.proxy.ClientProxy", serverSide = "com.nitrodev.constructio.proxy.ServerProxy")
    public static CommonProxy proxy;

    private GuiHandler guiHandler = new GuiHandler();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);

        Cioblocks.loadTE();
        Cioblocks.registerRenders();
        Cioitems.registerModels();
        ModRecipes.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);

        //MinecraftForge.EVENT_BUS.register(new CIOEventHandler());
    }

}
