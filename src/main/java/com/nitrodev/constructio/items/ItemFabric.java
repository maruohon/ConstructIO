package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemFabric extends Item {


    public ItemFabric(String unlocalisedName) {
        super();

        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName(unlocalisedName);
        this.setCreativeTab(ConstructIO.tabconstructio);
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < 16; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
