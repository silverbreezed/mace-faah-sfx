package org.silverbreezed.macefaahsfx.mixin;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.MaceItem;
import org.silverbreezed.macefaahsfx.client.tracker.SmashTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {

    @Inject(method = "attack", at = @At("HEAD"))
    private void onClientAttack(Player player, Entity targetEntity, CallbackInfo ci) {
        if (player.getMainHandItem().getItem() instanceof MaceItem) {
            SmashTracker.recordSmashIntent(targetEntity);
        }
    }
}