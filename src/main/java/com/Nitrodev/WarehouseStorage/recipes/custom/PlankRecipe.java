package com.nitrodev.warehousestorage.recipes.custom;


import com.google.common.primitives.Ints;
import com.nitrodev.warehousestorage.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class PlankRecipe implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        ItemStack saw = null;

        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack stackInSlot = inventoryCrafting.getStackInSlot(i);

            if (stackInSlot != null) {
                if (stackInSlot.getItem() == ModItems.itemSaw) {
                    if (saw != null) return false;
                    saw = stackInSlot;
                }
            }

            if (stackInSlot != null) {
                if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.wooden_slab)) {
                    if (saw != null) return false;
                    saw = stackInSlot;
                }
            }
        }
        return saw != null;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return null;
    }

    @Override
    public int getRecipeSize() {
        return 4;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inventoryCrafting) {
        return new ItemStack[0];
    }
}
