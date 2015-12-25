package com.Nitrodev.WarehouseStorage;

import com.Nitrodev.WarehouseStorage.client.render.items.ItemRenderRegister;
import com.Nitrodev.WarehouseStorage.items.ModItems;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.tools.nsc.settings.Final;

/**
 * Created by Jukka on 22.12.2015.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    private void registerModels() {
        registerItemModel(ModItems.itemPlank, "item_plank");
    }

    public void registerItemModel(final Item item, final String itemName) {
        registerItemModel(item, 0, itemName);
    }

    public void registerItemModel(final Item item, int meta, final String itemName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(WarehouseStorage.MODID + ":" + itemName, "inventory"));
        ModelBakery.addVariantName(item, WarehouseStorage.MODID + ":" + itemName);
    }
}
