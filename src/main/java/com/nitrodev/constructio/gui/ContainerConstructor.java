package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.TileConstructor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerConstructor extends Container {

    public ContainerConstructor(TileConstructor tileEntity, InventoryPlayer playerInventory) {

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return false;
    }
}
