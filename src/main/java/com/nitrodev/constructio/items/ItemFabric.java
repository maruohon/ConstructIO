package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructioTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFabric extends Item {

    public static CreativeTabs constructioTab = new ConstructioTab(CreativeTabs.getNextID(), "constructio");

    public ItemFabric(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_fabric");
        this.setCreativeTab(constructioTab);
    }
}
