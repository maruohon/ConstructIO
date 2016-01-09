package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.ConstructioTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Jukka on 22.12.2015.
 */
public class ItemPlank extends Item {


    public ItemPlank(String unlocalizedName){
        super();

        this.setUnlocalizedName("item_plank");
        this.setCreativeTab(ConstructIO.tabconstructio);
    }
}
