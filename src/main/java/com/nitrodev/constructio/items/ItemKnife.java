package com.nitrodev.constructio.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemKnife extends Item {

    public ItemKnife(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_knife");
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setMaxDamage(100);

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
