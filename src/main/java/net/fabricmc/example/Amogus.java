package net.fabricmc.example;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class Amogus extends Item {
    public Amogus(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.modid.amogus.tooltip.sus").formatted(Formatting.RED, Formatting.BOLD));
        for (int i = 0; i < 3; i++) {
            tooltip.add(
                    new TranslatableText(
                            "item.modid.amogus.tooltip.get_out_of_my_head")
                            .formatted(
                                    Formatting.BOLD,
                                    (i % 2 == 0 ? Formatting.GRAY : Formatting.WHITE)));
        }
    }
}
