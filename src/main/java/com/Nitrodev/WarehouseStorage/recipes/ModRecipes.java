package com.nitrodev.warehousestorage.recipes;

import com.nitrodev.warehousestorage.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {
    static ItemStack saw = new ItemStack(ModItems.itemSaw, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack slab = new ItemStack(Blocks.wooden_slab, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack stick = new ItemStack(Items.stick);
    static ItemStack iron = new ItemStack(Items.iron_ingot);

    public static void init() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemPlank), saw, slab);
        GameRegistry.addRecipe(
                new ItemStack(ModItems.itemSaw),
                "is ",
                " is",
                "  i",
                'i', iron, 's', stick);
    }
}
