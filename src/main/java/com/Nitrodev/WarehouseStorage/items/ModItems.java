package com.Nitrodev.WarehouseStorage.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Jukka on 22.12.2015.
 */
public class ModItems {

    public static Item itemPlank;

    public static void createItems() {
        GameRegistry.registerItem(itemPlank = new ItemPlank("item_plank"), "item_plank");
    }
}
