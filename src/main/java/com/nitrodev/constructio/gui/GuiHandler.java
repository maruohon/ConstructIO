package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.tileentitys.TETWCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_SmallWoodenCrate = 0;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;

        switch (id) {
            case GUI_SmallWoodenCrate:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity instanceof TETWCrate) {
                    return new ContainerWoodencrate(player.inventory, (TETWCrate) tileEntity);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;

        switch (id)
        {
            case GUI_SmallWoodenCrate:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity instanceof TETWCrate) {
                    return new GuiSmallWoodencrate(player.inventory, (TETWCrate) tileEntity);
                }

        }
        return null;
    }
}
