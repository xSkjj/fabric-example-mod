package net.fabricmc.example;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

/**
 * Callback for getting attacked by an entity or something
 */
public interface EntityAttackCallback {
    Event<EntityAttackCallback> EVENT = EventFactory.createArrayBacked(EntityAttackCallback.class,
            (listeners) -> (source, player) -> {
                for (EntityAttackCallback event : listeners) {
                    ActionResult result = event.interact(source, player);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            }
            );

    ActionResult interact(DamageSource source, PlayerEntity player);
}
