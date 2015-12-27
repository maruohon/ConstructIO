package com.nitrodev.warehousestorage.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item itemPlank;
    public static Item itemSaw;

    public static void createItems() {
        GameRegistry.registerItem(itemPlank = new ItemPlank("item_plank"), "item_plank");
        GameRegistry.registerItem(itemSaw = new ItemSaw("item_saw"), "item_saw");
    }
}
