package com.ming_hai.permanentnightvision;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("permanentnightvision")
public class PermanentNightVisionMod {
    public static final String MODID = "permanentnightvision";
    
    public PermanentNightVisionMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // 事件处理器已通过注解自动注册
    }
}