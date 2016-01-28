package com.nitrodev.constructio.blocks.storage;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.blocks.tileentitys.TETWCrate;
import com.nitrodev.constructio.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WoodenCrate extends Block {

    public WoodenCrate() {
        super(Material.wood);

        this.setUnlocalizedName("woodencrate");
        this.setCreativeTab(ConstructIO.tabconstructio);
        this.setStepSound(soundTypeWood);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TETWCrate();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);

        playerIn.openGui(ConstructIO.instance, GuiHandler.GUI_SmallWoodenCrate, worldIn, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);

        if (tileEntity instanceof TETWCrate) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TETWCrate)tileEntity);

        }
        super.breakBlock(worldIn, pos, state);
    }
}
