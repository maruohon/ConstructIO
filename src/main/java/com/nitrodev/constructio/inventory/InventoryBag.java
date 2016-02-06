package com.nitrodev.constructio.inventory;

import com.nitrodev.constructio.utils.NBTUtils;
import com.nitrodev.constructio.utils.RandomUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import java.util.UUID;

public class InventoryBag implements IInventory {

    protected ItemStack stack;
    protected int invSize;
    protected ItemStack[] items;
    //The NBTTagList tag name to store the items in the container
    protected String itemsTagName;
    protected EntityPlayer player;
    protected boolean isRemote;
    protected String customInvName;
    protected int stackLimit;
    protected boolean ignoreMaxStack;
    protected UUID containerUUID;
    protected IInventory hostInv;

    public InventoryBag(ItemStack containerStack, int invSize, boolean isRemote, EntityPlayer player) {
        this(containerStack, invSize, isRemote, player, "Items");
    }

    public InventoryBag(ItemStack containerStack, int invSize, boolean isRemote, EntityPlayer player, String tagName) {
        this(containerStack, invSize, isRemote, player, tagName, null, null);
    }

    public InventoryBag(ItemStack containerStack, int invSize, boolean isRemote, EntityPlayer player, String tagName, UUID containerUUID, IInventory hostInv) {
        this.stack = containerStack;
        this.invSize = invSize;
        this.player = player;
        this.isRemote = isRemote;
        this.stackLimit = 64;
        this.containerUUID = containerUUID;
        this.hostInv = hostInv;
        this.itemsTagName = tagName;
        this.initInventory();
    }

    public void setIsRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }

    protected void initInventory() {
        this.items = new ItemStack[this.getSizeInventory()];//Client for the client too
    }

    public void setItemStorageTagName(String tagName) {
        if (tagName != null) {
            this.itemsTagName = tagName;
        }
    }

    public void setHostInv(IInventory inv, UUID uuid) {
        this.hostInv = inv;
        this.containerUUID = uuid;
    }

    public ItemStack getContainerItemStack() {
        //System.out.println("InventoryItem#getContainerItemStack() - " + (this.isRemote ? "client" : "server"));
        if (this.containerUUID != null && this.hostInv != null) {
            return getItemStackByUUID(this.hostInv, this.containerUUID, "UUID");
        }

        return this.stack;
    }
    
    public void setContainerItemStack(ItemStack stack) {
        this.stack = stack;
        this.readFromContainerItemStack();
    }

    public void setCustomInvName(String name) {
        this.customInvName = name;
    }

    public void setStackLimit(int stackLimit) {
        this.stackLimit = stackLimit;
    }

    public void setIgnoreMaxStack(boolean ignore) {
        this.ignoreMaxStack = ignore;
    }

    public boolean getIgnoreMaxStack() {
        return this.ignoreMaxStack;
    }

    public void readFromContainerItemStack() {
        if (this.isRemote == false) {
            this.initInventory();

            ItemStack stack = this.getContainerItemStack();
            if (stack != null && this.isUseableByPlayer(this.player) == true) {
                RandomUtils.readItemsFromContainerItem(stack, this.items, this.itemsTagName);
            }
        }
    }

    protected void writeToContainerItemStack() {
        if (this.isRemote == false) {
            ItemStack stack = this.getContainerItemStack();
            if (stack != null && this.isUseableByPlayer(this.player) == true) {
                RandomUtils.writeItemsToContainerItem(stack, this.items, this.itemsTagName, true);
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return this.invSize;
    }

    public void setInvSize(int size) {
        this.invSize = size;
        this.initInventory();
    }

    @Override
    public ItemStack getStackInSlot(int slotNum) {
        if (slotNum < this.items.length) {
            return this.items[slotNum];
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int slotNum, ItemStack stack) {
        if (slotNum < this.items.length) {
            this.items[slotNum] = stack;

            this.markDirty();
        }
    }

    @Override
    public ItemStack decrStackSize(int slotNum, int count) {
        ItemStack stack = null;

        if (slotNum < this.items.length)
        {
            if (this.items[slotNum] != null)
            {
                if (this.items[slotNum].stackSize >= count)
                {
                    stack = this.items[slotNum].splitStack(count);

                    if (this.items[slotNum].stackSize <= 0)
                    {
                        this.items[slotNum] = null;
                    }
                }
                else
                {
                    stack = this.items[slotNum];
                    this.items[slotNum] = null;
                }
            }

            this.markDirty();
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int slotNum) {

        ItemStack stack = null;
        if (slotNum < this.items.length) {
            stack = this.items[slotNum];
            this.items[slotNum] = null;

            this.markDirty();
        }
        return stack;
    }

    @Override
    public int getInventoryStackLimit() {
        return this.stackLimit;
    }

    @Override
    public boolean isItemValidForSlot(int slotNum, ItemStack stack) {

        return this.getContainerItemStack() != null;
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
    public void markDirty() {
        if (this.isRemote == false) {
            this.writeToContainerItemStack();
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

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
        for (int i = 0; i < this.getSizeInventory(); i++) {
            this.items[i] = null;
        }
    }

    @Override
    public IChatComponent getDisplayName() {
        IChatComponent displayName = new ChatComponentText("Bag");
        return displayName;
    }

    public static ItemStack getItemStackByUUID(IInventory inv, UUID uuid, String containerTagName) {
        int size = inv.getSizeInventory();

        for (int i = 0; i < size; i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && uuid.equals(NBTUtils.getUUIDFromItemStack(stack, containerTagName, false)) == true) {
                return stack;
            }
        }

        return null;
    }
}