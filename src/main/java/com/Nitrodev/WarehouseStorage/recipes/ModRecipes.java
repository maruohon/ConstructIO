package com.nitrodev.warehousestorage.recipes;

import com.nitrodev.warehousestorage.recipes.custom.PlankRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void addRecipes() {
        GameRegistry.addRecipe(new PlankRecipe());
    }
}
