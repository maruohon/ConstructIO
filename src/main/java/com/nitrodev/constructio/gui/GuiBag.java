package com.nitrodev.constructio.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiBag extends GuiContainer {

    private static final ResourceLocation bagGuiTextures = new ResourceLocation("constructio:textures/gui/bag.png");
    private final ContainerBag containerBag;
    private final InventoryPlayer playerInv;

    public GuiBag(EntityPlayer player, ContainerBag containerBag) {
        super(containerBag);
        this.playerInv = player.inventory;
        this.containerBag = containerBag;

        this.ySize = 212;
        this.xSize = 212;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = this.containerBag.bagInv.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(name, 42, 22, 4210752);
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 120, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bagGuiTextures);
        int lvt_4_1_ = (this.width - this.xSize) / 2;
        int lvt_5_1_ = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lvt_4_1_, lvt_5_1_, 0, 0, this.xSize, this.ySize);
    }
}
