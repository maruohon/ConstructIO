package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerConstructor extends Container {
    private IInventory constructorInventory;
    static final int MachineSlots = 9;
    static final int PlayerSlots = 9*4;

    public ContainerConstructor(IInventory playerInv, IInventory tileEntity) {
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
