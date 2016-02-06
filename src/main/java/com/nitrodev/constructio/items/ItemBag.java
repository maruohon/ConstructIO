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
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote == false) {
            player.openGui(ConstructIO.instance, GuiHandler.GUI_Bag, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }

        return itemStack;
    }
}
