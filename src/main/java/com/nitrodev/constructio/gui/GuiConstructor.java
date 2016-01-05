package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.TileConstructor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiConstructor extends GuiContainer {


    public GuiConstructor(InventoryPlayer playerInventory, TileConstructor tileEntity) {
        super(new ContainerConstructor(tileEntity, playerInventory));

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i1) {

    }

}
