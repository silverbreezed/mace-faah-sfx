package org.silverbreezed.macefaahsfx;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.silverbreezed.macefaahsfx.sound.ModSounds;

@Mod(Constants.MOD_ID)
public class MaceFaahSFX {

    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "macefaahsfx");

    public MaceFaahSFX() {

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        BusGroup modEventBus = FMLJavaModLoadingContext.get().getModBusGroup();

        SOUNDS.register(ModSounds.MOD_ID, ModSounds.FAAH_SOUND);

        SOUNDS.register(modEventBus);

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

    }
}