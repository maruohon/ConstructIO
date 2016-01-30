package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.ConstructioTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemKnife extends ItemSword {


    public ItemKnife(String unlocalisedName) {
        super(ToolMaterial.IRON);

        this.setUnlocalizedName("item_knife");
        this.setCreativeTab(ConstructIO.tabconstructio);
        this.setMaxDamage(100);
    }

    @Override
    public float getDamageVsEntity() {
        return 1.0f;
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
