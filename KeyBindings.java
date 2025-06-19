package com.ming_hai.permanentnightvision;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final KeyMapping TOGGLE_NIGHT_VISION = new KeyMapping(
            "key.permanentnightvision.toggle",
            GLFW.GLFW_KEY_G,
            "key.categories.permanentnightvision"
    );

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(TOGGLE_NIGHT_VISION);
        }
    }
}