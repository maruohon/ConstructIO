package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import net.minecraft.item.Item;

public class ItemBag extends Item {
    public ItemBag() {
        super();

        this.setUnlocalizedName("bag");
        this.setCreativeTab(ConstructIO.tabconstructio);
    }
}
