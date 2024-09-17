package com.momo.alexsmobs_tfc.mixins.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityAnteater;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityAnteater.class)
public class AMTFCAnteaterMixin {

    /**
     * @author momo
     * @reason Disable breeding
     */
    @Overwrite
    public boolean isFood(ItemStack stack) {
        return false;
    }

    /**
     * @author momo
     * @reason Disable interactions
     */
    @Overwrite
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return InteractionResult.PASS;
    }
}
