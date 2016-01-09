package com.nitrodev.constructio.blocks;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.ConstructioTab;
import com.nitrodev.constructio.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockConstructor extends Block {


    public BlockConstructor() {
        super(Material.wood);
        this.setUnlocalizedName("blockConstructor");
        this.setCreativeTab(ConstructIO.tabconstructio);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

        TileEntity tileEntity = worldIn.getTileEntity(pos);

        if(tileEntity instanceof TileConstructor) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileConstructor) tileEntity);
            worldIn.updateComparatorOutputLevel(pos,this);
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileConstructor();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {

        TileEntity tileEntity = worldIn.getTileEntity(pos);

        playerIn.openGui(ConstructIO.instance, GuiHandler.GUI_Constructor, worldIn, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }
}
