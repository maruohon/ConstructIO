package com.Nitrodev.warehousestorage.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Voider extends Block {

    public Voider() {
        super(Material.cactus);

        this.setUnlocalizedName("blockVoider");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
