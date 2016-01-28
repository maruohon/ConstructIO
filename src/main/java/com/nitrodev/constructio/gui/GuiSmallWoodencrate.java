package com.nitrodev.constructio.gui;

import com.nitrodev.constructio.blocks.tileentitys.TETWCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiSmallWoodencrate extends GuiContainer {

    private static final ResourceLocation woodencrateGuiTextures = new ResourceLocation("constructio:textures/gui/smallwoodencrate.png");
    private final InventoryPlayer playerInventory;
    public IInventory woodencrateInventory;

    public GuiSmallWoodencrate(InventoryPlayer playerInv, TETWCrate tileEntity) {
        super(new ContainerWoodencrate(playerInv, tileEntity));
        this.playerInventory = playerInv;
        this.woodencrateInventory = tileEntity;

        this.ySize = 212;
        this.xSize = 212;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = this.woodencrateInventory.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(name, 42, 22, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, 120, 4210752);
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
