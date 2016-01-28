package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerWoodencrate extends Container {

    public EntityPlayer player;
    private IInventory woodencrateInventory;
    static final int MachineSlots = 16;
    static final int PlayerSlots = 9*4;

    public ContainerWoodencrate(IInventory playerInv, IInventory tileEntity) {
        this.woodencrateInventory = tileEntity;

        int i;
        int j;
        for(i = 0; i < 4; ++i) {
            for(j = 0; j < 4; ++j) {
                this.addSlotToContainer(new Slot(tileEntity, j + i * 4, 52 + j * 18, 35 + i * 18));
            }
        }

        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 130 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 188));
        }

    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.woodencrateInventory.isUseableByPlayer(player);
    }

    //For shift-clicking from the inventory
    //If return null then can't be shift-clicked
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerEntity, int slotIndex) {

        Slot slot = this.inventorySlots.get(slotIndex);
        if (slot == null || !slot.getHasStack()) {

            return null;
        }

        ItemStack stack = slot.getStack();
        ItemStack stackCopy = stack.copy();

        int startIndex;
        int endIndex;

        if (slotIndex < MachineSlots) {

            startIndex = MachineSlots;
            endIndex = MachineSlots + PlayerSlots;

        } else {

            startIndex = 0;
            endIndex = MachineSlots;
        }



        if (!this.mergeItemStack(stack, startIndex, endIndex, false))
        {
            return null;
        }

        if (stack.stackSize == 0)
        {
            slot.putStack(null);
        }
        else
        {
            slot.onSlotChanged();
        }

        if (stack.stackSize == stackCopy.stackSize)
        {
            return null;
        }

        slot.onPickupFromSlot(playerEntity, stack);
        return stackCopy;
    }
}
