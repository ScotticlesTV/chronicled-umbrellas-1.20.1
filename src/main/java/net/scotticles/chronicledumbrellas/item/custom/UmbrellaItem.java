package net.scotticles.chronicledumbrellas.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.scotticles.chronicledumbrellas.item.ModItems;
import net.scotticles.chronicledumbrellas.util.ModTags;

public class UmbrellaItem extends Item {
    public UmbrellaItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {

            ItemStack offHandItem = player.getOffHandStack();
            ItemStack mainHandItem = player.getMainHandStack();

            boolean holdingUmbrella = offHandItem.getItem() instanceof UmbrellaItem ||
                    mainHandItem.getItem() instanceof UmbrellaItem;

            if (holdingUmbrella) {
                if (!player.isOnGround() && player.getVelocity().y < 0 && !player.isSubmergedInWater()) {
                    Vec3d vel = player.getVelocity();
                    double newY = vel.y * 0.75; // Reduce vertical speed (adjust as needed)
                    player.setVelocity(vel.x, newY, vel.z);
                    player.velocityDirty = true; // Important for syncing on server

                    player.fallDistance = 0.0F;
                }
            }
        }
    }



}