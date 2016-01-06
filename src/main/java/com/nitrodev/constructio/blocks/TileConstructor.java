package com.nitrodev.constructio.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class TileConstructor extends TileEntity implements IInventory {

    private ItemStack[] stacks = new ItemStack[36];

    public int getSizeInventory() {
        return stacks.length;
    }

    public ItemStack getStackInSlot(int index) {
        return this.stacks[index];
    }

    public ItemStack decrStackSize(int index, int count) {
        if (this.stacks[index] != null) {
            ItemStack itemStack;
            if (this.stacks[index].stackSize <= count) {
                itemStack = this.stacks[index];
                this.stacks[index] = null;
                this.markDirty();
                return itemStack;
            } else {
                itemStack = this.stacks[index].splitStack(count);
                if (this.stacks[index].stackSize == 0) {
                    this.stacks[index] = null;
                }

                this.markDirty();
                return itemStack;
            }
        } else {
            return null;
        }
    }

    public ItemStack removeStackFromSlot(int p_removeStackFromSlot_1_) {
        if (this.stacks[p_removeStackFromSlot_1_] != null) {
            ItemStack lvt_2_1_ = this.stacks[p_removeStackFromSlot_1_];
            this.stacks[p_removeStackFromSlot_1_] = null;
            return lvt_2_1_;
        } else {
            return null;
        }
    }


    public void setInventorySlotContents(int p_setInventorySlotContents_1_, ItemStack p_setInventorySlotContents_2_) {
        this.stacks[p_setInventorySlotContents_1_] = p_setInventorySlotContents_2_;
        if (p_setInventorySlotContents_2_ != null && p_setInventorySlotContents_2_.stackSize > this.getInventoryStackLimit()) {
            p_setInventorySlotContents_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    public String getName() {
        return null;
    }

    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        IChatComponent displayName = new ChatComponentText("Constructor");
        return displayName;
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList lvt_2_1_ = compound.getTagList("Items", 10);
        this.stacks = new ItemStack[this.getSizeInventory()];

        for (int lvt_3_1_ = 0; lvt_3_1_ < lvt_2_1_.tagCount(); ++lvt_3_1_) {
            NBTTagCompound lvt_4_1_ = lvt_2_1_.getCompoundTagAt(lvt_3_1_);
            int lvt_5_1_ = lvt_4_1_.getByte("Slot") & 255;
            if (lvt_5_1_ >= 0 && lvt_5_1_ < this.stacks.length) {
                this.stacks[lvt_5_1_] = ItemStack.loadItemStackFromNBT(lvt_4_1_);
            }
        }

    }

    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList lvt_2_1_ = new NBTTagList();

        for (int lvt_3_1_ = 0; lvt_3_1_ < this.stacks.length; ++lvt_3_1_) {
            if (this.stacks[lvt_3_1_] != null) {
                NBTTagCompound lvt_4_1_ = new NBTTagCompound();
                lvt_4_1_.setByte("Slot", (byte) lvt_3_1_);
                this.stacks[lvt_3_1_].writeToNBT(lvt_4_1_);
                lvt_2_1_.appendTag(lvt_4_1_);
            }
        }

    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer p_isUseableByPlayer_1_) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : p_isUseableByPlayer_1_.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer p_openInventory_1_) {
    }

    public void closeInventory(EntityPlayer p_closeInventory_1_) {
    }

    public boolean isItemValidForSlot(int p_isItemValidForSlot_1_, ItemStack p_isItemValidForSlot_2_) {
        return true;
    }


    public int getField(int p_getField_1_) {
        return 0;
    }

    public void setField(int p_setField_1_, int p_setField_2_) {
    }

    public int getFieldCount() {
        return 0;
    }

    public void clear() {
        for (int lvt_1_1_ = 0; lvt_1_1_ < this.stacks.length; ++lvt_1_1_) {
            this.stacks[lvt_1_1_] = null;
        }

    }
}