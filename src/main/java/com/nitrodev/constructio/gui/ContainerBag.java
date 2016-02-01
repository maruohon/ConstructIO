package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class ContainerBag extends Container {

    public ContainerBag(IInventory player) {

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
