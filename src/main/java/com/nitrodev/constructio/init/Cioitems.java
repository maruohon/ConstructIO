package com.nitrodev.constructio.init;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.blocks.WoodenShell;
import com.nitrodev.constructio.items.*;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cioitems {

    public static Item itemPlank;
    public static Item itemSaw;
    public static Item itemKnife;
    public static Item itemHammer;
    public static Item itemFabric;
    public static Item itemWoodenShell;
    public static Item itemBag;

    public static void register() {
        GameRegistry.registerItem(itemPlank = new ItemPlank("item_plank"), "item_plank");
        GameRegistry.registerItem(itemSaw = new ItemSaw("item_saw"), "item_saw");
        GameRegistry.registerItem(itemKnife = new ItemKnife("item_knife"), "item_knife");
        GameRegistry.registerItem(itemHammer = new ItemHammer("item_hammer"), "item_hammer");
        GameRegistry.registerItem(itemFabric = new ItemFabric(), "fabric");
        GameRegistry.registerItem(itemWoodenShell = new WoodenShell("item_woodenshell"), "item_woodenshell");
        GameRegistry.registerItem(itemBag = new ItemBag(), "bag");
    }

    public static void registerModels() {
        registerItemModel(itemPlank, "item_plank");
        registerItemModel(itemSaw, "item_saw");
        registerItemModel(itemKnife, "item_knife");
        registerItemModel(itemHammer, "item_hammer");
        registerItemModel(itemWoodenShell, "item_woodenshell");
        for (int i = 0; i < 16; i++) {
            registerItemModel(itemFabric, i,"fabric/" + "fabric" + i);
        }
    }

    public static void registerItemModel(final Item item, final String itemName) {
        registerItemModel(item, 0, itemName);
    }

    public static void registerItemModel(final Item item, int meta, final String itemName) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ConstructIO.MODID + ":" + itemName, "inventory"));
    }
}
