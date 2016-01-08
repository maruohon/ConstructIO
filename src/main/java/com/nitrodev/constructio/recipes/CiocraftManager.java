package com.nitrodev.constructio.recipes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nitrodev.constructio.init.Cioitems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;

public class CiocraftManager {

    private static final CiocraftManager instance = new CiocraftManager();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

    public static CiocraftManager getInstance() {
        return instance;
    }

    private CiocraftManager() {
        this.addRecipe(new ItemStack(Cioitems.itemFabric), new Object[] {" SSS ", " SSS ", " SSS ", " SSS ", " SSS ", 'S', Items.string});
    }

    public CioShapedRecipe addRecipe(ItemStack result, Object... recipeComponents) {
        String s = "";
        int i = 0;
        int width = 0;
        int height = 0;

        if (recipeComponents[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipeComponents[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++height;
                width = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (recipeComponents[i] instanceof String)
            {
                String s2 = (String)recipeComponents[i++];
                ++height;
                width = s2.length();
                s = s + s2;
            }
        }

        HashMap hashMap;

        for (hashMap = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2)
        {
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack1 = null;

            if (recipeComponents[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if (recipeComponents[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if (recipeComponents[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)recipeComponents[i + 1];
            }

            hashMap.put(character, itemstack1);
        }

        ItemStack[] ingredients = new ItemStack[width * height];

        for (int i1 = 0; i1 < width * height; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashMap.containsKey(Character.valueOf(c0)))
            {
                ingredients[i1] = ((ItemStack)hashMap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                ingredients[i1] = null;
            }
        }

        CioShapedRecipe shapedrecipes = new CioShapedRecipe(width, height, ingredients, result);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public ItemStack findMatchingRecipe(InventoryCrafting matrix, World world) {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(matrix, world))
            {
                return irecipe.getCraftingResult(matrix);
            }
        }

        return null;
    }
}

