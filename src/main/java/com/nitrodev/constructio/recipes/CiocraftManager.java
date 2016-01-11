package com.nitrodev.constructio.recipes;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;
import java.util.Map;

public class CiocraftManager {

    private static final CiocraftManager instance = new CiocraftManager();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();


    public static CiocraftManager getInstance() {
        //The static instance of this class
        return instance;
    }

    private CiocraftManager() {

    }

    public CioShapedRecipe addRecipe(ItemStack itemStack, Object... recipeComponents) {
        String s = "";
        int i = 0;
        int width = 0;
        int height = 0;

        if (recipeComponents[i] instanceof String[]) {
            String[] astring = (String[])((String[])recipeComponents[i++]);

            for (int l = 0; l < astring.length; ++l){
                String s1 = astring[l];
                ++height;
                width = s1.length();
                s = s + s1;
            }
        } else {
            while (recipeComponents[i] instanceof String) {
                String s2 = (String)recipeComponents[i++];
                ++height;
                width = s2.length();
                s = s + s2;
            }
        }

        Map<Character, ItemStack>map;


        return null;
    }

}

