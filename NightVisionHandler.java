package com.ming_hai.permanentnightvision;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class NightVisionHandler {
    private static boolean isActive = false;
    private static final int DURATION = 1000000; // 约16分钟
    
    public static void toggleNightVision() {
        isActive = !isActive;
        applyNightVisionEffect();
    }
    
    private static void applyNightVisionEffect() {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) return;
        
        if (isActive) {
            // 创建自定义夜视效果（无粒子、无UI）
            MobEffectInstance customNightVision = new MobEffectInstance(
                    MobEffects.NIGHT_VISION, 
                    DURATION, 
                    0, 
                    false,  // 无粒子
                    false,  // 无图标
                    false   // 无环境特效
            );
            player.addEffect(customNightVision);
        } else {
            player.removeEffect(MobEffects.NIGHT_VISION);
        }
    }
    
    public static void onClientTick() {
        if (isActive) {
            // 每tick检查并重新应用效果
            applyNightVisionEffect();
        }
    }
}