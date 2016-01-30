package com.nitrodev.constructio.recipes;

import com.nitrodev.constructio.init.Cioblocks;
import com.nitrodev.constructio.init.Cioitems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {
    static ItemStack knife = new ItemStack(Cioitems.itemKnife, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack saw = new ItemStack(Cioitems.itemSaw, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack slab = new ItemStack(Blocks.wooden_slab, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack stick = new ItemStack(Items.stick);
    static ItemStack iron = new ItemStack(Items.iron_ingot);
    static ItemStack goldblock = new ItemStack(Blocks.gold_block);
    static ItemStack cactus = new ItemStack(Blocks.cactus);
    static ItemStack hopper = new ItemStack(Blocks.hopper);

    public static void init() {
        //Items
        GameRegistry.addShapelessRecipe(new ItemStack(Cioitems.itemPlank), saw, slab);
        for (int i = 0; i < 16; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(Cioitems.itemFabric, 1, i), knife, new ItemStack(Blocks.wool, 1, i));
        }
        GameRegistry.addRecipe(
                new ItemStack(Cioitems.itemSaw),
                "ss ",
                " is",
                "  s",
                'i', iron, 's', stick);
        GameRegistry.addRecipe(
                new ItemStack(Cioitems.itemKnife),
                "   ",
                "ii ",
                "  s",
                'i', iron, 's', stick);
        //Blocks
        GameRegistry.addRecipe(
                new ItemStack(Cioblocks.voider),
                "ghg",
                "hch",
                "ghg",
                'g', goldblock, 'c', cactus, 'h', hopper);
    }
}
