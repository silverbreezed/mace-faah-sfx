package org.silverbreezed.macefaahsfx.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.world.entity.Entity;
import org.silverbreezed.macefaahsfx.client.manager.MemeSoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {

    @Inject(method = "handleEntityEvent", at = @At("RETURN"))
    private void onEntityEventPacket(ClientboundEntityEventPacket packet, CallbackInfo ci) {
        byte status = packet.getEventId();

        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            Entity targetEntity = packet.getEntity(level);
            if (targetEntity != null && (status == 3 || status == 35)) {
                MemeSoundManager.handleEntityStatus(targetEntity, status);
            }
        }
    }
}