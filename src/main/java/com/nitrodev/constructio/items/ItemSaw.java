package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.ConstructioTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemSaw extends Item {


    public ItemSaw(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_saw");
        this.setCreativeTab(ConstructIO.tabconstructio);
        this.setMaxDamage(10);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return stack.getItemDamage() < stack.getMaxDamage();
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack newStack = itemStack.copy();
        return newStack.attemptDamageItem(1, itemRand) ? null : newStack;
    }
}
