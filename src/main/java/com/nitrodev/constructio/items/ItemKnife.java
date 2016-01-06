package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructioTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemKnife extends Item {

    public static CreativeTabs constructioTab = new ConstructioTab(CreativeTabs.getNextID(), "constructio");

    public ItemKnife(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_knife");
        this.setCreativeTab(constructioTab);
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
