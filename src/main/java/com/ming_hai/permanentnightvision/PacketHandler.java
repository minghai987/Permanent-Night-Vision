package com.ming_hai.permanentnightvision;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class PacketHandler {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new net.minecraft.resources.ResourceLocation("permanentnightvision", "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );
    
    public static void register() {
        INSTANCE.registerMessage(0, TogglePacket.class, 
                TogglePacket::encode, 
                TogglePacket::new, 
                PacketHandler::handleToggle);
    }
    
    public static void sendTogglePacket() {
        INSTANCE.sendToServer(new TogglePacket());
    }
    
    private static void handleToggle(TogglePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().setPacketHandled(true);
    }
    
    public static class TogglePacket {
        public TogglePacket() {}
        
        public TogglePacket(FriendlyByteBuf buf) {}
        
        public void encode(FriendlyByteBuf buf) {}
    }
}