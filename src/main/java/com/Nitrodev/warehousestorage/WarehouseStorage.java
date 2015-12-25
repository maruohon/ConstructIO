package com.Nitrodev.warehousestorage;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = WarehouseStorage.MODID, version = WarehouseStorage.VERSION, name = WarehouseStorage.NAME)
public class WarehouseStorage
{
    public static final String MODID = "warehousestorage";
    public static final String VERSION = "1.0";
    public static final String NAME = "Warehouse Storage";

    @SidedProxy(clientSide = "com.Nitrodev.warehousestorage.ClientProxy", serverSide = "com.Nitrodev.warehousestorage.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
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
