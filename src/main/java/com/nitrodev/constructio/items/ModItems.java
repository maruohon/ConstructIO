package com.nitrodev.constructio.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item itemPlank;
    public static Item itemSaw;
    public static Item itemKnife;
    public static Item itemHammer;

    public static void createItems() {
        GameRegistry.registerItem(itemPlank = new ItemPlank("item_plank"), "item_plank");
        GameRegistry.registerItem(itemSaw = new ItemSaw("item_saw"), "item_saw");
        GameRegistry.registerItem(itemKnife = new ItemKnife("item_knife"), "item_knife");
        GameRegistry.registerItem(itemHammer = new ItemHammer("item_hammer"), "item_hammer");
    }
}
