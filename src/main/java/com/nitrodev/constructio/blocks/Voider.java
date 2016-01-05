package com.nitrodev.constructio.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Voider extends Block {

    public Voider() {
        super(Material.cactus);

        this.setUnlocalizedName("blockVoider");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public AxisAlignedBB getCollisionBoundingBox(World p_getCollisionBoundingBox_1_, BlockPos p_getCollisionBoundingBox_2_, IBlockState p_getCollisionBoundingBox_3_) {
        float f = 0.0625F;
        return new AxisAlignedBB((double)((float)p_getCollisionBoundingBox_2_.getX() + f), (double)p_getCollisionBoundingBox_2_.getY(), (double)((float)p_getCollisionBoundingBox_2_.getZ() + f), (double)((float)(p_getCollisionBoundingBox_2_.getX() + 1) - f), (double)((float)(p_getCollisionBoundingBox_2_.getY() + 1) - f), (double)((float)(p_getCollisionBoundingBox_2_.getZ() + 1) - f));
    }

    public void onEntityCollidedWithBlock(World p_onEntityCollidedWithBlock_1_, BlockPos p_onEntityCollidedWithBlock_2_, IBlockState p_onEntityCollidedWithBlock_3_, Entity p_onEntityCollidedWithBlock_4_) {
        if (p_onEntityCollidedWithBlock_4_ instanceof EntityItem) {
        p_onEntityCollidedWithBlock_4_.attackEntityFrom(DamageSource.generic, 5.0F);
        }
    }
}
