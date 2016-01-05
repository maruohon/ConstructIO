package com.nitrodev.constructio.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHammer extends Item {

    public ItemHammer(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_hammer");
        this.setMaxDamage(100);
        this.setCreativeTab(CreativeTabs.tabTools);
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
