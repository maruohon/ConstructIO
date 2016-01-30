package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.init.Cioitems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemFabric extends Item {

    private final static String[] subNames = {"white", "orange", "magenta", "light_blue", "yellow",
            "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

    public ItemFabric() {
        super();

        this.setHasSubtypes(true);
        this.setUnlocalizedName("fabric");
        this.setCreativeTab(ConstructIO.tabconstructio);
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < 16; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int sub = stack.getItemDamage();

        if (sub >= subNames.length) {
            sub = 0;
        }

        return getUnlocalizedName() + "_" + subNames[sub];
    }
}
