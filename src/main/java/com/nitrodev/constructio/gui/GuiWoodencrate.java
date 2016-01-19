package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.TileConstructor;
import com.nitrodev.constructio.blocks.storage.TECrateMaster;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiWoodencrate extends GuiContainer {

    private static final ResourceLocation woodencrateGuiTextures = new ResourceLocation("constructio:textures/gui/woodencrate.png");
    private final InventoryPlayer playerInventory;
    public IInventory woodencrateInventory;

    public GuiWoodencrate(InventoryPlayer playerInv, TECrateMaster tileEntity) {
        super(new ContainerConstructor(playerInv, tileEntity));
        this.playerInventory = playerInv;
        this.woodencrateInventory = tileEntity;

        this.ySize = 202;
        this.xSize = 212;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = this.woodencrateInventory.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(name, 26, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, 107, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(woodencrateGuiTextures);
        int lvt_4_1_ = (this.width - this.xSize) / 2;
        int lvt_5_1_ = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lvt_4_1_, lvt_5_1_, 0, 0, this.xSize, this.ySize);
    }
}
