package com.nitrodev.constructio.blocks.tileentitys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class TETWCrate extends TileEntity implements IInventory {

    private ItemStack[] stacks = new ItemStack[16];

    @Override
    public int getSizeInventory() {
        return stacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.stacks[index];
    }

    @Override
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

    @Override
    public ItemStack removeStackFromSlot(int index) {
        if (this.stacks[index] != null) {
            ItemStack lvt_2_1_ = this.stacks[index];
            this.stacks[index] = null;
            return lvt_2_1_;
        } else {
            return null;
        }
    }

    @Override
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

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.stacks[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int lvt_1_1_ = 0; lvt_1_1_ < this.stacks.length; ++lvt_1_1_) {
            this.stacks[lvt_1_1_] = null;
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        IChatComponent displayName = new ChatComponentText("Small Wooden Crate");
        return displayName;
    }
}
