package com.nitrodev.constructio.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBag extends Container {

    private IInventory bagInv;
    static final int MachineSlots = 18;
    static final int PlayerSlots = 9*4;

    public ContainerBag(IInventory player, IInventory bagInv) {
        this.bagInv = bagInv;

        int y;
        int x;
        for (y = 0; y < 2; ++y) {
            for (x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(bagInv, y * 9 + x, 52 + x * 15, 35 + y * 18));
            }
        }

        for(x = 0; x < 3; ++x) {
            for(y = 0; y < 9; ++y) {
                this.addSlotToContainer(new Slot(player, y + x * 9 + 9, 8 + y * 18, 130 + x * 18));
            }
        }

        for(x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 188));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.bagInv.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNum) {
        Slot slot = this.inventorySlots.get(slotNum);
        if (slot == null || !slot.getHasStack()) {

            return null;
        }

        ItemStack stack = slot.getStack();
        ItemStack stackCopy = stack.copy();

        int startIndex;
        int endIndex;

        if (slotNum < MachineSlots) {

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

        slot.onPickupFromSlot(player, stack);
        return stackCopy;
    }
}
