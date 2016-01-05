package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.TileConstructor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiConstructor extends GuiContainer {
    private static final ResourceLocation constructorGuiTextures = new ResourceLocation("textures/gui/constructor.png");
    private final InventoryPlayer playerInventory;
    public IInventory constructorInventory;

    public GuiConstructor(InventoryPlayer playerInv, TileConstructor tileEntity) {
        super(new ContainerConstructor(tileEntity, playerInv));
        this.playerInventory = playerInv;
        this.constructorInventory = tileEntity;

    }
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        String lvt_3_1_ = this.constructorInventory.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lvt_3_1_, this.xSize / 2 - this.fontRendererObj.getStringWidth(lvt_3_1_) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(constructorGuiTextures);
        int lvt_4_1_ = (this.width - this.xSize) / 2;
        int lvt_5_1_ = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lvt_4_1_, lvt_5_1_, 0, 0, this.xSize, this.ySize);
    }
}
