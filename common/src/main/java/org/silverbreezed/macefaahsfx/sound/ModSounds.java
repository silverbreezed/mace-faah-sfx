package org.silverbreezed.macefaahsfx.sound;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import java.util.function.Supplier;

public class ModSounds {

    public static final String MOD_ID = "macefaahsfx";

    public static final Identifier FAAH_ID = Identifier.fromNamespaceAndPath(MOD_ID, "faah");

    public static final Supplier<SoundEvent> FAAH_SOUND = () -> SoundEvent.createVariableRangeEvent(FAAH_ID);
}
