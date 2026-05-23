package net.scotticles.chronicledumbrellas.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.scotticles.chronicledumbrellas.ChronicledUmbrellas;

public class ModSounds {
    public static final SoundEvent OPENUMBRELLA = registerSoundEvent("openumbrella");
    public static final SoundEvent CLOSEUMBRELLA = registerSoundEvent("closeumbrella");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ChronicledUmbrellas.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {ChronicledUmbrellas.LOGGER.info("Registering Sounds for" + ChronicledUmbrellas.MOD_ID);
    }
}