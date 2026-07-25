package org.silverbreezed.macefaahsfx.sound;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import java.util.function.Supplier;

public class ModSounds {

    public static final String MOD_ID = "macefaahsfx";

    // Gunakan ResourceLocation (NMS Vanilla), bukan Identifier (Fabric)
    public static final Identifier FAAH_ID = Identifier.fromNamespaceAndPath(MOD_ID, "faah");

    // Dibungkus di dalam Supplier agar TIDAK mengeksekusi registrasi otomatis saat kelas dimuat
    public static final Supplier<SoundEvent> FAAH_SOUND = () -> SoundEvent.createVariableRangeEvent(FAAH_ID);
}
