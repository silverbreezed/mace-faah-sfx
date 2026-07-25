package org.silverbreezed.macefaahsfx.client.tracker;

import net.minecraft.world.entity.Entity;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SmashTracker {
    private static final Map<UUID, Long> recentSmashes = new ConcurrentHashMap<>();

    public static void recordSmashIntent(Entity target) {
        recentSmashes.put(target.getUUID(), System.currentTimeMillis());
    }

    public static boolean verifyAndConsume(Entity target) {
        Long smashTime = recentSmashes.remove(target.getUUID());
        if (smashTime == null) return false;

        return (System.currentTimeMillis() - smashTime) <= 500;
    }
}