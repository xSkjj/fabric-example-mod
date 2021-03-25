

package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.fabricmc.example.EntityAttackCallback;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;


@Mixin(ServerPlayerEntity.class)
public class EntityAttackMixin {
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void onEntityInteractPlayer(DamageSource source, float amount, CallbackInfoReturnable<Boolean> info) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        ActionResult result = EntityAttackCallback.EVENT.invoker().interact(source, player);

        if (result != ActionResult.PASS) {
            info.cancel();
        }
    }
}
