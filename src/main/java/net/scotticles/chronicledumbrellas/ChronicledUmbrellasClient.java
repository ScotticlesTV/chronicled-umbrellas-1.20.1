package net.scotticles.chronicledumbrellas;

import net.fabricmc.api.ClientModInitializer;
import net.scotticles.chronicledumbrellas.event.UmbrellaClientUpdate;

public class ChronicledUmbrellasClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UmbrellaClientUpdate.UmbrellaClientUpdate();
    }
}
