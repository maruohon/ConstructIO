package com.nitrodev.constructio.blocks;

import com.nitrodev.constructio.ConstructIO;
import net.minecraft.item.Item;

public class WoodenShell extends Item {

    public WoodenShell(String unlocalisedName) {
        super();

        this.setUnlocalizedName(unlocalisedName);
        this.setCreativeTab(ConstructIO.tabconstructio);
    }
}
