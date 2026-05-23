package net.scotticles.chronicledumbrellas.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.scotticles.chronicledumbrellas.item.custom.UmbrellaItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public abstract class PlayerEntityModelMixin<T extends LivingEntity>
        extends BipedEntityModel<T> {

    @Shadow public ModelPart rightSleeve;
    @Shadow public ModelPart leftSleeve;

    public PlayerEntityModelMixin(ModelPart root) {
        super(root);
    }

        @Inject(method = "setAngles", at = @At("TAIL"))
        private void umbrellaPose(
            T entity,
            float limbAngle,
            float limbDistance,
            float animationProgress,
            float headYaw,
            float headPitch,
            CallbackInfo ci
        ) {
        if (!(entity instanceof PlayerEntity player))
            return;


        // Check if the umbrella is being used (if not, stop)
        boolean usingUmbrella =
                player.isUsingItem() && player.getActiveItem().getItem() instanceof UmbrellaItem;

        if (!usingUmbrella) {
            return;
        }

        // Find which arm is using the umbrella
        Arm armSide;
        if (player.getActiveHand() == Hand.MAIN_HAND) {
            armSide = player.getMainArm();
        } else {
            armSide = player.getMainArm().getOpposite();
        }

        ModelPart arm;
        ModelPart sleeve;

        // Set the targeted arm to be the arm actively using the umbrella
        if (armSide == Arm.RIGHT) {
            arm = this.rightArm;
            sleeve = this.rightSleeve;
        } else {
            arm = this.leftArm;
            sleeve = this.leftSleeve;
        }

        // Pose The Arm
        arm.pitch = -2.8f;
        arm.yaw = 0.0f;
        arm.roll = 0.0f;

        // Pose The Sleeve (Match Arm Pose)
        sleeve.pitch = -2.8f;
        sleeve.yaw = 0.0f;
        sleeve.roll = 0.0f;
    }
}