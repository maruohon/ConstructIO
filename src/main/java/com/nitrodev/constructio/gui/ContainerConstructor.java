package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerConstructor extends Container {
    private IInventory constructorInventory;

    public ContainerConstructor(IInventory p_i45799_1_, IInventory p_i45799_2_) {
        this.constructorInventory = p_i45799_2_;

        int lvt_3_3_;
        int lvt_4_2_;
        for(lvt_3_3_ = 0; lvt_3_3_ < 3; ++lvt_3_3_) {
            for(lvt_4_2_ = 0; lvt_4_2_ < 3; ++lvt_4_2_) {
                this.addSlotToContainer(new Slot(p_i45799_2_, lvt_4_2_ + lvt_3_3_ * 3, 62 + lvt_4_2_ * 18, 17 + lvt_3_3_ * 18));
            }
        }

        for(lvt_3_3_ = 0; lvt_3_3_ < 3; ++lvt_3_3_) {
            for(lvt_4_2_ = 0; lvt_4_2_ < 9; ++lvt_4_2_) {
                this.addSlotToContainer(new Slot(p_i45799_1_, lvt_4_2_ + lvt_3_3_ * 9 + 9, 8 + lvt_4_2_ * 18, 84 + lvt_3_3_ * 18));
            }
        }

        for(lvt_3_3_ = 0; lvt_3_3_ < 9; ++lvt_3_3_) {
            this.addSlotToContainer(new Slot(p_i45799_1_, lvt_3_3_, 8 + lvt_3_3_ * 18, 142));
        }

    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.constructorInventory.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer p_transferStackInSlot_1_, int p_transferStackInSlot_2_) {
        ItemStack lvt_3_1_ = null;
        Slot lvt_4_1_ = (Slot)this.inventorySlots.get(p_transferStackInSlot_2_);
        if(lvt_4_1_ != null && lvt_4_1_.getHasStack()) {
            ItemStack lvt_5_1_ = lvt_4_1_.getStack();
            lvt_3_1_ = lvt_5_1_.copy();
            if(p_transferStackInSlot_2_ < 9) {
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

            lvt_4_1_.onPickupFromSlot(p_transferStackInSlot_1_, lvt_5_1_);
        }

        return lvt_3_1_;
    }
}
