package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerConstructor extends Container {
    private IInventory constructorInventory;

    public ContainerConstructor(IInventory tileEntity, IInventory playerInv) {
        this.constructorInventory = playerInv;

        int i;
        int j;
        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 3; ++j) {
                this.addSlotToContainer(new Slot(playerInv, j + i * 3, 62 + j * 18, 17 + i * 18));
            }
        }

        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(tileEntity, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(tileEntity, i, 8 + i * 18, 142));
        }

    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.constructorInventory.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer playerEntity, int i) {
        ItemStack lvt_3_1_ = null;
        Slot lvt_4_1_ = (Slot)this.inventorySlots.get(i);
        if(lvt_4_1_ != null && lvt_4_1_.getHasStack()) {
            ItemStack lvt_5_1_ = lvt_4_1_.getStack();
            lvt_3_1_ = lvt_5_1_.copy();
            if(i < 9) {
                if(!this.mergeItemStack(lvt_5_1_, 9, 45, true)) {
                    return null;
                }
            } else if(!this.mergeItemStack(lvt_5_1_, 0, 9, false)) {
                return null;
            }

            if(lvt_5_1_.stackSize == 0) {
                lvt_4_1_.putStack((ItemStack)null);
            } else {
                lvt_4_1_.onSlotChanged();
            }

            if(lvt_5_1_.stackSize == lvt_3_1_.stackSize) {
                return null;
            }

            lvt_4_1_.onPickupFromSlot(playerEntity, lvt_5_1_);
        }

        return lvt_3_1_;
    }
}
