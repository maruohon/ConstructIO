package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import net.minecraft.item.Item;

public class ItemFabric extends Item {


    public ItemFabric(String unlocalisedName) {
        super();

        this.setUnlocalizedName("item_fabric");
        this.setCreativeTab(ConstructIO.tabconstructio);
    }
}
