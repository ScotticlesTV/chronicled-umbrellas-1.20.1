package net.scotticles.chronicledumbrellas.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.scotticles.chronicledumbrellas.item.custom.UmbrellaItem;

public class UmbrellaClientUpdate {

    public static void UmbrellaClientUpdate() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player != null) {

                boolean usingUmbrella =
                        player.isUsingItem() && player.getActiveItem().getItem() instanceof UmbrellaItem;

                if (usingUmbrella) {
                    if (!player.isOnGround() && !player.isSubmergedInWater() && player.getVelocity().y < 0) {
                        // Get the player's velocity
                        Vec3d vel = player.getVelocity();
                        // Set the player's y-velocity to 3/4ths what it was
                        player.setVelocity(vel.x, vel.y * 0.75, vel.z);
                        player.velocityDirty = true; // Important for syncing on server
                        // Disable fall damage
                        player.fallDistance = 0.0F;
                    }
                }
            }
        });
    }
}
