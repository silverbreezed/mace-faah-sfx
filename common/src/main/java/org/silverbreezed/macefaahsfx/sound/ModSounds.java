package org.silverbreezed.macefaahsfx.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static final String MOD_ID = "macefaahsfx";

    public static final SoundEvent FAAH_SOUND = registerSoundEvent();

    private static SoundEvent registerSoundEvent() {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, "faah");

        return Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                id,
                SoundEvent.createVariableRangeEvent(id)
        );
    }

    public static void initialize() {
        System.out.println("Mendaftarkan Custom Sounds untuk " + MOD_ID);
    }
}