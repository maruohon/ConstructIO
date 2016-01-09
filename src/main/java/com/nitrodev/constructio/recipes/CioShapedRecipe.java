package com.nitrodev.constructio.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

public class CioShapedRecipe extends ShapedRecipes {

    public final int recipeWidth;
    public final int recipeHeight;
    public final ItemStack[] recipeItems;
    public final ItemStack recipeOutput;

    public CioShapedRecipe(int width, int height, ItemStack[] recipeItems, ItemStack output) {
        super(width, height, recipeItems, output);

        this.recipeWidth = width;
        this.recipeHeight = height;
        this.recipeItems = recipeItems;
        this.recipeOutput = output;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return super.getCraftingResult(inv);
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return super.matches(inv, worldIn);
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return super.getRemainingItems(inv);
    }

    @Override
    public int getRecipeSize() {
        return recipeHeight*recipeWidth;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return super.getRecipeOutput();
    }
}