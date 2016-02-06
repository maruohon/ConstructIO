package com.nitrodev.constructio.items;

import com.nitrodev.constructio.ConstructIO;
import com.nitrodev.constructio.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemBag extends Item {
    public ItemBag() {
        super();

        this.setUnlocalizedName("bag");
        this.setCreativeTab(ConstructIO.tabconstructio);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

        player.openGui(ConstructIO.instance, GuiHandler.GUI_Bag, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

}
