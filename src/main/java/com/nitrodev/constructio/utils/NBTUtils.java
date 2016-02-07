package com.nitrodev.constructio.utils;

import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.UUID;

public class NBTUtils {

    public static NBTTagCompound writeTagToNBT(NBTTagCompound nbt, String name, NBTBase tag) {

        if (name == null) {
            return nbt;
        }

        if (nbt == null) {
            if (tag == null) {
                return nbt;
            }

            nbt = new NBTTagCompound();
        }

        if (tag == null) {
            nbt.removeTag(name);
        } else {
            nbt.setTag(name, tag);
        }

        return nbt;
    }

    public static ItemStack setRootCompoundTag(ItemStack stack, NBTTagCompound nbt) {

        if (nbt.hasNoTags() == true) {
            nbt = null;
        }

        stack.setTagCompound(nbt);
        return stack;
    }

    public static NBTTagCompound getRootCompoundTag(ItemStack stack, boolean create) {

        NBTTagCompound nbt = stack.getTagCompound();
        if (create == false) {
            return nbt;
        }

        if (nbt == null) {
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        return nbt;
    }

    public static NBTTagCompound getCompoundTag(NBTTagCompound nbt, String tagName, boolean create) {

        if (nbt == null) {
            return null;
        }

        if (create == false) {
            return nbt.hasKey(tagName, Constants.NBT.TAG_COMPOUND) == true ? nbt.getCompoundTag(tagName) : null;
        }

        //true
        if (nbt.hasKey(tagName, Constants.NBT.TAG_COMPOUND) == false) {
            nbt.setTag(tagName, new NBTTagCompound());
        }

        return nbt.getCompoundTag(tagName);
    }

    public static NBTTagCompound getCompoundTag(ItemStack stack, String tagName, boolean create) {
        NBTTagCompound nbt = getRootCompoundTag(stack, create);

        if (tagName != null) {
            nbt = getCompoundTag(nbt, tagName, create);
        }

        return nbt;
    }

    public static UUID getUUIDFromItemStack(ItemStack stack, String containerTagName, boolean create) {
        NBTTagCompound nbt = getCompoundTag(stack, containerTagName, create);

        UUID uuid = getUUIFromNBT(nbt);
        if (uuid == null && create == true) {
            uuid = UUID.randomUUID();
            nbt.setLong("UUIDM", uuid.getMostSignificantBits());
            nbt.setLong("UUIDL", uuid.getLeastSignificantBits());
        }

        return uuid;
    }

    public static UUID getUUIFromNBT(NBTTagCompound nbt) {
        if (nbt != null && nbt.hasKey("UUIDM", Constants.NBT.TAG_LONG) && nbt.hasKey("UUIDL", Constants.NBT.TAG_LONG)) {
            return new UUID(nbt.getLong("UUIDM"), nbt.getLong("UUIDL"));
        }

        return null;
    }

    public static NBTTagList getTagList(ItemStack containerStack, String containerTagName, String tagName, int tagType, boolean create) {
        NBTTagCompound nbt = getCompoundTag(containerStack, containerTagName, create);
        if (create == true && nbt.hasKey(tagName, Constants.NBT.TAG_LIST) == false) {
            nbt.setTag(tagName, new NBTTagList());
        }

        return nbt != null ? nbt.getTagList(tagName, tagType) : null;
    }
}
