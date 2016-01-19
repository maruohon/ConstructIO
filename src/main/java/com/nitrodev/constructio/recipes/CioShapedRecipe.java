/*package com.nitrodev.constructio.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CioShapedRecipe extends ShapedRecipes {

    public final int recipeWidth;
    public final int recipeHeight;
    public final ItemStack[] recipeItems;
    public final ItemStack recipeOutput;
    private boolean copyIngredientNBT;

    public CioShapedRecipe(int width, int height, ItemStack[] recipeItems, ItemStack output) {
        super(width, height, recipeItems, output);

        this.recipeWidth = width;
        this.recipeHeight = height;
        this.recipeItems = recipeItems;
        this.recipeOutput = output;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {

        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);
            aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
        }
        return aitemstack;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        for (int i = 0; i <= 5 - this.recipeWidth; ++i) {
            for (int j = 0; j <= 5 - this.recipeHeight; ++j) {
                if (this.checkMatch(inv, i, j, true)) {
                    return true;
                }
                if (this.checkMatch(inv, i, j, false)){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean checkMatch(InventoryCrafting inv, int i, int j, boolean choice) {
        for (int i1 = 0; i1 < 5; ++i1) {
            for (int j1 = 0; j1 < 5; ++j1) {

                int k = i1 - i;
                int l = j1 - j;
                ItemStack itemstack = null;

                if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight) {
                    if (choice) {
                        itemstack = this.recipeItems[this.recipeWidth - k - 1 + l * this.recipeWidth];
                    }
                    else {
                        itemstack = this.recipeItems[k + l * this.recipeWidth];
                    }
                }

                ItemStack itemStack = inv.getStackInRowAndColumn(i1, j1);

                if (itemStack != null || itemstack != null) {
                    if (itemStack == null && itemstack != null || itemStack != null && itemstack == null) {
                        return false;
                    }
                    if (itemstack.getItem() != itemStack.getItem()) {
                        return false;
                    }
                    if (itemstack.getMetadata() != 32767 && itemstack.getMetadata() != itemStack.getMetadata()) {
                        return false;
                    }
                }
            }
        }
       return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack itemStack = this.getRecipeOutput().copy();
        if (this.copyIngredientNBT) {
            for (int i = 0; i < inv.getSizeInventory(); ++i) {
                ItemStack itemStack1 = inv.getStackInSlot(i);
                if (itemStack1 != null && itemStack1.hasTagCompound()){
                    itemStack.setTagCompound((NBTTagCompound)itemStack1.getTagCompound().copy());
                }
            }
        }
        return itemStack;
    }

    @Override
    public int getRecipeSize() {
        return recipeHeight*recipeWidth;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }
}*/