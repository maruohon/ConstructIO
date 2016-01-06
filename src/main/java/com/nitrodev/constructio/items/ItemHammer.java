package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructioTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHammer extends Item {

    public static CreativeTabs constructioTab = new ConstructioTab(CreativeTabs.getNextID(), "constructio");

    public ItemHammer(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_hammer");
        this.setMaxDamage(100);
        this.setCreativeTab(constructioTab);
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
