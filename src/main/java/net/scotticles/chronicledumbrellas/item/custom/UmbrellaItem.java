package net.scotticles.chronicledumbrellas.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.scotticles.chronicledumbrellas.item.ModItems;
import net.scotticles.chronicledumbrellas.util.ModTags;

public class UmbrellaItem extends Item {
    public UmbrellaItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {

                ItemStack offHandItem = player.getOffHandStack();
                ItemStack mainHandItem = player.getMainHandStack();

                if (offHandItem.getItem() instanceof UmbrellaItem) {
                    if (!player.hasStatusEffect(StatusEffects.SLOW_FALLING
                    )) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.
                                SLOW_FALLING
                                , 1, 0, false, false, false));
                    }
                }
                else {
                    if (mainHandItem.getItem() instanceof UmbrellaItem) {
                        if (!player.hasStatusEffect(StatusEffects.SLOW_FALLING
                        )) {
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.
                                    SLOW_FALLING
                                    , 1, 0, false, false, false));
                        }
                    }
                }
            }
        }
    }

}