package com.Nitrodev.WarehouseStorage.client.render.items;

import com.Nitrodev.WarehouseStorage.WarehouseStorage;
import com.Nitrodev.WarehouseStorage.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by Jukka on 22.12.2015.
 */
public class ItemRenderRegister {

    public static String modid = WarehouseStorage.MODID;

    public static void registerItemRenderer() {
        reg(ModItems.itemPlank);
    }

    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.itemPlank, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5)));
    }
}
