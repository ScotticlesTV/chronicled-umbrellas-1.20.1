package net.scotticles.chronicledumbrellas.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.scotticles.chronicledumbrellas.sound.ModSounds;

public class UmbrellaItem extends Item {
    public UmbrellaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.OPENUMBRELLA, SoundCategory.PLAYERS, 0.15f, 1f);
        }

        user.setCurrentHand(hand);


        return TypedActionResult.consume(stack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTime) {
        if(!world.isClient()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.CLOSEUMBRELLA, SoundCategory.PLAYERS, 0.15f, 1f);
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {

            // Create a bool for whether or not the umbrella is actively being used
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
    }



}