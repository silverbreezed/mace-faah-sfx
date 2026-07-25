package org.silverbreezed.macefaahsfx;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.silverbreezed.macefaahsfx.sound.ModSounds;

@Mod(Constants.MOD_ID)
public class MaceFaahSFX {

    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "macefaahsfx");

    public MaceFaahSFX(IEventBus modEventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        SOUNDS.register(ModSounds.MOD_ID, ModSounds.FAAH_SOUND);

        SOUNDS.register(modEventBus);

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

    }
}