package com.nitrodev.constructio.blocks.storage;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WoodenCrate extends Block {

    public WoodenCrate() {
        super(Material.wood);

        this.setUnlocalizedName("woodenCrate");
        this.setCreativeTab(ConstructIO.tabconstructio);
        this.setStepSound(soundTypeWood);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TECrateMaster();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);

        playerIn.openGui(ConstructIO.instance, GuiHandler.GUI_WoodenCrate, worldIn, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }
}
