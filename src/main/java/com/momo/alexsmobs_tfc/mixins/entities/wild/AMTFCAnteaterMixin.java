package com.momo.alexsmobs_tfc.mixins.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityAnteater;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityAnteater.class)
public abstract class AMTFCAnteaterMixin extends Animal {

    protected AMTFCAnteaterMixin(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
    }

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

    @Override
    public boolean canBeLeashed(Player player) {
        return Helpers.isEntity(this, TFCTags.Entities.LEASHABLE_WILD_ANIMALS);
    };
}
