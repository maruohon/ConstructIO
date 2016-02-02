package com.nitrodev.constructio.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

import java.util.UUID;
import java.util.function.Consumer;

public class InventoryBag implements IInventory {

    protected final ItemStack[] stacks = new ItemStack[18];
    static final String NBT_UUID_KEY = "constructio.itemUuid";

    UUID uuid;

    protected final ItemStack stack;
    protected final String nbtkey;

    private final Consumer<ItemStack> changeListener;

    protected InventoryBag(ItemStack stack, String nbtkey) {
        this(stack, nbtkey, defaultChangeListener());
    }

    protected InventoryBag(int size, ItemStack stack, String nbtkey) {
        this(size, stack, nbtkey, defaultChangeListener());
    }

    private static Consumer<ItemStack> defaultChangeListener() {
        return stack -> {
        };
    }

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
            ItemStack stack = this.stacks[index];
            this.stacks[index] = null;
            return stack;
        } else {
            return null;
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
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
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
        return null;
    }

    public void readFromNBT(NBTTagCompound compound) {
        NBTTagList tagList = compound.getTagList("Items", 10);
        this.stacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound lvt_4_1_ = tagList.getCompoundTagAt(i);
            int lvt_5_1_ = lvt_4_1_.getByte("Slot") & 255;
            if (lvt_5_1_ >= 0 && lvt_5_1_ < this.stacks.length) {
                this.stacks[lvt_5_1_] = ItemStack.loadItemStackFromNBT(lvt_4_1_);
            }
        }

    }

    public void writeToNBT(NBTTagCompound compound) {
        NBTTagList list = new NBTTagList();
        for (int slot = 0, size = getSizeInventory(); slot < size; slot++) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                NBTTagCompound slotNBT = new NBTTagCompound();
                slotNBT.setInteger("slot", slot);
                stack.writeToNBT(slotNBT);
                list.appendTag(slotNBT);
            }
        }
        compound.setTag("constructio.bagInv", list);
    }
}
