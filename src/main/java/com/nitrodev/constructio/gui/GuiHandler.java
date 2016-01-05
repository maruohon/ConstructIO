package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.TileConstructor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_Constructor = 0;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;

        switch (id) {
            case GUI_Constructor:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity instanceof TileConstructor) {
                    return new ContainerConstructor((TileConstructor) tileEntity, player.inventory);
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
            case GUI_Constructor:
                tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity instanceof TileConstructor)
                {
                    return new GuiConstructor(player.inventory, (TileConstructor) tileEntity);
                }
                break;

        }

        return null;
    }
}
