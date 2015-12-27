package com.nitrodev.warehousestorage.recipes.custom;


import com.nitrodev.warehousestorage.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.Random;

public class PlankRecipe implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        ItemStack saw = null;
        ItemStack slab = null;

        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack stackInSlot = inventoryCrafting.getStackInSlot(i);

            if (stackInSlot != null) {
                if (stackInSlot.getItem() == ModItems.itemSaw) {
                    if (saw != null) return false;
                    saw = stackInSlot;
                }
                if (stackInSlot.getItem() == Item.getItemFromBlock(Blocks.wooden_slab)) {
                    if (slab != null) return false;
                    slab = stackInSlot;
                }

            }

        }
        return saw != null && slab != null;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return getRecipeOutput().copy();
    }

    @Override
    public int getRecipeSize() {
        return 4;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.itemPlank);
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        ItemStack[] result = new ItemStack[4];
        for (int i = 0; i < result.length; ++i) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && stack.getItem() == ModItems.itemSaw) {
                result[i] = stack.copy();

                if (result[i].attemptDamageItem(1, new Random())) {
                    if (--result[i].stackSize <= 0) {
                        result[i] = null;
                    }
                }
            }
        }

        return result;

    }
}
