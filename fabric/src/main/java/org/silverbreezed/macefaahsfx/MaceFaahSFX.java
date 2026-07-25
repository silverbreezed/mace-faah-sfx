package org.silverbreezed.macefaahsfx;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import org.silverbreezed.macefaahsfx.sound.ModSounds;

public class MaceFaahSFX implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Registry.register(BuiltInRegistries.SOUND_EVENT, ModSounds.MOD_ID, ModSounds.FAAH_SOUND.get());
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
    }
}
