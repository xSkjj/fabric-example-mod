package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {

    public static final Amogus amogus = new Amogus(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1));

    @Override
    public void onInitialize() {
        System.out.println("\n\n\nHello Fabric world!\n\n");

        Registry.register(Registry.ITEM, new Identifier("modid", "amogus"), amogus);
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            System.out.println("AttackEntityCallback:\n" +
                    "player:...." + player + "\n" +
                    "world:_____" + world + "\n" +
                    "hand:......" + hand + "\n" +
                    "entity:____" + entity + "\n" +
                    "hitResult:." + hitResult);
            return ActionResult.PASS;
        });
        EntityAttackCallback.EVENT.register((source, player) -> {
            System.out.println("EntityAttackCallback:\n" +
                    "source: " + source + "\n" +
                    "player: " + player + "\n" +
                    "player.\"knockbackVelocity\": " + player.knockbackVelocity);
            return ActionResult.PASS;
        });
    }
}
