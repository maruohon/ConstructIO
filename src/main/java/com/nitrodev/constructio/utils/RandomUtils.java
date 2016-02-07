package com.nitrodev.constructio.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class RandomUtils {

    public static void readItemsFromContainerItem(ItemStack containerStack, ItemStack[] items) {
        readItemsFromContainerItem(containerStack, items, "Items");
    }

    public static void readItemsFromContainerItem(ItemStack containerStack, ItemStack[] items, String tagName) {
        NBTTagList nbtTagList = NBTUtils.getTagList(containerStack, null, tagName, Constants.NBT.TAG_COMPOUND, false);
        if (nbtTagList == null) {
            return;
        }

        int num = nbtTagList.tagCount();
        for (int i = 0; i < num; ++i) {
            NBTTagCompound tag = nbtTagList.getCompoundTagAt(i);
            byte slotNum = tag.getByte("Slot");

            if (slotNum >= 0 && slotNum < items.length) {
                items[slotNum] = ItemStack.loadItemStackFromNBT(tag);
                if (items[slotNum] != null && tag.hasKey("ActualCount", Constants.NBT.TAG_INT)) {
                    items[slotNum].stackSize = tag.getInteger("ActualCount");
                }
            }
        }
    }

    public static void writeItemsToContainerItem(ItemStack containerStack, ItemStack[] items, boolean keepExtra) {
        writeItemsToContainerItem(containerStack, items, "Items", keepExtra);
    }

    public static void writeItemsToContainerItem(ItemStack containerStack, ItemStack[] items, String tagName, boolean keepExtra) {
        NBTTagList nbtTagList = new NBTTagList();
        int invSlots = items.length;
        for (int slotNum = 0; slotNum < invSlots && slotNum <= 127; ++slotNum) {
            if (items[slotNum] != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte)slotNum);
                tag.setInteger("ActualCount", items[slotNum].stackSize);
                items[slotNum].writeToNBT(tag);
                nbtTagList.appendTag(tag);
            }
        }

        if (keepExtra == true) {
            NBTTagList nbtTagListExist = NBTUtils.getTagList(containerStack, null, tagName, Constants.NBT.TAG_COMPOUND, false);
            if (nbtTagListExist != null) {
                for (int i = 0; i < nbtTagListExist.tagCount(); ++i) {
                    NBTTagCompound tag = nbtTagListExist.getCompoundTagAt(i);
                    byte slotNum = tag.getByte("Slot");
                    if (slotNum >= invSlots && slotNum <= 127) {
                        nbtTagList.appendTag(tag);
                    }
                }
            }
        }

        NBTTagCompound nbt = NBTUtils.getCompoundTag(containerStack, null, true);
        if (nbtTagList.tagCount() > 0) {
            nbt.setTag(tagName, nbtTagList);
        } else {
            nbt.removeTag(tagName);
        }

        //NBTUtils.setRootCompoundTag(containerStack, nbt);
    }
}
