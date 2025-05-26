package net.scotticles.chronicledumbrellas.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.scotticles.chronicledumbrellas.item.custom.UmbrellaItem;

public class UmbrellaClientUpdate {

    public static void UmbrellaClientUpdate() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player != null) {
                ItemStack mainHand = player.getMainHandStack();
                ItemStack offHand = player.getOffHandStack();

                boolean holdingUmbrella = mainHand.getItem() instanceof UmbrellaItem || offHand.getItem() instanceof UmbrellaItem;

                if (holdingUmbrella && !player.isOnGround() && !player.isSubmergedInWater() && player.getVelocity().y < 0) {
                    Vec3d vel = player.getVelocity();
                    double newY = vel.y * 0.75; // Reduce vertical speed (adjust as needed)
                    player.setVelocity(vel.x, newY, vel.z);
                    player.velocityDirty = true; // Important for syncing on server
                }
            }
        });


}
}
