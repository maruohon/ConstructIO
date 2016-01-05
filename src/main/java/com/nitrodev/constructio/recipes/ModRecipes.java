package com.nitrodev.constructio.recipes;

import com.nitrodev.constructio.init.Wsblocks;
import com.nitrodev.constructio.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {
    static ItemStack saw = new ItemStack(ModItems.itemSaw, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack slab = new ItemStack(Blocks.wooden_slab, 1, OreDictionary.WILDCARD_VALUE);
    static ItemStack stick = new ItemStack(Items.stick);
    static ItemStack iron = new ItemStack(Items.iron_ingot);
    static ItemStack goldblock = new ItemStack(Blocks.gold_block);
    static ItemStack cactus = new ItemStack(Blocks.cactus);
    static ItemStack hopper = new ItemStack(Blocks.hopper);

    public static void init() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemPlank), saw, slab);
        GameRegistry.addRecipe(
                new ItemStack(ModItems.itemSaw),
                "is ",
                " is",
                "  i",
                'i', iron, 's', stick);
        GameRegistry.addRecipe(
                new ItemStack(Wsblocks.voider),
                "ghg",
                "hch",
                "ghg",
                'g', goldblock, 'c', cactus, 'h', hopper);
    }
}
