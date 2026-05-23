package net.scotticles.chronicledumbrellas;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.scotticles.chronicledumbrellas.event.UmbrellaClientUpdate;
import net.scotticles.chronicledumbrellas.item.ModItems;
import net.scotticles.chronicledumbrellas.item.custom.UmbrellaItem;

public class ChronicledUmbrellasClient implements ClientModInitializer {

    private static void registerUmbrellaPrediate(Item item) {
        ModelPredicateProviderRegistry.register(
                item,
                new Identifier("usingumbrella"),
                (stack, world, entity, seed) -> {

                    if (entity == null)
                        return 0f;

                    boolean usingUmbrella =
                            entity.isUsingItem() && entity.getActiveItem() == stack;

                    if (usingUmbrella) {
                        return 1f;
                    }
                    else {
                        return 0f;
                    }
                }
        );
    }

    @Override
    public void onInitializeClient() {
        UmbrellaClientUpdate.UmbrellaClientUpdate();
        registerUmbrellaPrediate(ModItems.RedUmbrella);
        registerUmbrellaPrediate(ModItems.OrangeUmbrella);
        registerUmbrellaPrediate(ModItems.YellowUmbrella);
        registerUmbrellaPrediate(ModItems.GreenUmbrella);
        registerUmbrellaPrediate(ModItems.BlueUmbrella);
        registerUmbrellaPrediate(ModItems.PurpleUmbrella);
        registerUmbrellaPrediate(ModItems.BlackUmbrella);
        registerUmbrellaPrediate(ModItems.WhiteUmbrella);
        registerUmbrellaPrediate(ModItems.BrownUmbrella);
    }
}
