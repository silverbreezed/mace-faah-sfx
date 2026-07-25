package org.silverbreezed.macefaahsfx.client.manager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import org.silverbreezed.macefaahsfx.client.config.ModConfig;
import org.silverbreezed.macefaahsfx.client.tracker.SmashTracker;
import org.silverbreezed.macefaahsfx.sound.ModSounds;

public class MemeSoundManager {

    public static void playFaahSound(ClientLevel level, Vec3 pos) {
        if (level == null || Minecraft.getInstance().player == null) return;

        ModConfig config = ConfigManager.getConfig();

        if (!config.enabled) {
            return;
        }

        level.playLocalSound(
                pos.x, pos.y, pos.z,
                ModSounds.FAAH_SOUND,
                SoundSource.PLAYERS,
                config.volume, 1.0f, false
        );
    }

    public static void handleEntityStatus(Entity entity, byte status) {
        if (!(entity instanceof LivingEntity livingEntity)) return;

        System.out.println("[MaceFaahSFX]: Status: " + status);

        if (SmashTracker.verifyAndConsume(livingEntity)) {
            playFaahSound((ClientLevel) livingEntity.level(), livingEntity.position());
        }
    }
}