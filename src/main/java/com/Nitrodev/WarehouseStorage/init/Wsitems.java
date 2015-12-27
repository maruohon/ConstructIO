package com.nitrodev.warehousestorage.init;

import com.nitrodev.warehousestorage.WarehouseStorage;
import com.nitrodev.warehousestorage.items.ModItems;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class Wsitems {

    public static void registerModels() {
        registerItemModel(ModItems.itemPlank, "item_plank");
        registerItemModel(ModItems.itemSaw, "item_saw");
    }

    public static void registerItemModel(final Item item, final String itemName) {
        registerItemModel(item, 0, itemName);
    }

    public static void registerItemModel(final Item item, int meta, final String itemName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(WarehouseStorage.MODID + ":" + itemName, "inventory"));
    }
}
