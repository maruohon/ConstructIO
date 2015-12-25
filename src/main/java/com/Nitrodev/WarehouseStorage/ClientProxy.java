package com.Nitrodev.warehousestorage;

import com.Nitrodev.warehousestorage.blocks.Voider;
import com.Nitrodev.warehousestorage.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(voider), 0, new ModelResourceLocation(voider, "inventory"));
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void registerModels() {
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
