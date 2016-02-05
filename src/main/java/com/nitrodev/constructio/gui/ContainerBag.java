package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerBag extends Container {

    private IInventory bagInv;

    public ContainerBag(IInventory player, IInventory bagInv) {
        this.bagInv = bagInv;

        int y;
        int x;
        for (y = 0; y < 2; ++y) {
            for (x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(bagInv, y + x*))
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
