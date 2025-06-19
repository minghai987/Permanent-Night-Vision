package com.ming_hai.permanentnightvision;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientEventHandler {
    
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (KeyBindings.TOGGLE_NIGHT_VISION.consumeClick()) {
            NightVisionHandler.toggleNightVision();
        }
    }
    
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            NightVisionHandler.onClientTick();
        }
    }
}