package com.nitrodev.constructio;

import com.nitrodev.constructio.init.Cioitems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConstructioTab extends CreativeTabs {

    public ConstructioTab(int index, String label) {
        super(index, label);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Cioitems.itemHammer;
    }
}
