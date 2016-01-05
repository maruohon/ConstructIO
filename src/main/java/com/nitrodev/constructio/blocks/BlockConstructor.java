package com.nitrodev.constructio.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConstructor extends Block {

    public BlockConstructor() {
        super(Material.wood);
        this.setUnlocalizedName("blockConstructor");
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileConstructor();
    }


}
