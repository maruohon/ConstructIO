package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.tileentitys.TETWCrate;
import com.nitrodev.constructio.init.Cioitems;
import com.nitrodev.constructio.inventory.InventoryBag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_WoodenCrate = 0;
    public static final int GUI_Bag = 1;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;
        ItemStack stack;

        switch (id) {
            case GUI_WoodenCrate:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity instanceof TETWCrate) {
                    return new ContainerWoodencrate(player.inventory, (TETWCrate) tileEntity);
                }
                break;
            case GUI_Bag:
                stack = player.getCurrentEquippedItem();
                if (stack != null && stack.getItem() == Cioitems.itemBag) {
                    return new ContainerBag(player.inventory, new InventoryBag(stack, 18, false, player));
                }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;
        ItemStack stack;

        switch (id)
        {
            case GUI_WoodenCrate:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity instanceof TETWCrate) {
                    return new GuiWoodencrate(player.inventory, (TETWCrate) tileEntity);
                }
                break;
            case GUI_Bag:
                stack = player.getCurrentEquippedItem();
                if (stack != null && stack.getItem() == Cioitems.itemBag) {
                    return new GuiBag(player.inventory, new InventoryBag(stack, 18, false, player));
                }

        }
        return null;
    }
}
