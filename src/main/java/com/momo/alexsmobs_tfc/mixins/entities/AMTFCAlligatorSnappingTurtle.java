package com.momo.alexsmobs_tfc.mixins.entities;

import com.github.alexthe666.alexsmobs.entity.EntityAlligatorSnappingTurtle;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.plant.Plant;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nonnull;
import java.util.Collections;

// Abstract for cleaner @Shadow code
@Mixin(EntityAlligatorSnappingTurtle.class)
public abstract class AMTFCAlligatorSnappingTurtle extends Animal {

    protected AMTFCAlligatorSnappingTurtle(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    // "Copies" getMoss() method
    @Shadow
    public abstract int getMoss();

    // "Copies" setMoss() method
    @Shadow
    public abstract void setMoss(int moss);


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
     * @reason Needed to change the else block to drop TFC moss instead of vanilla Sea grass
     */
    @Overwrite
    public void shear(SoundSource category) {
        this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, category, 1.0F, 1.0F);
        this.gameEvent(GameEvent.ENTITY_INTERACT);
        if (!this.level().isClientSide) {
            if (random.nextFloat() < this.getMoss() * 0.05F) {
                this.spawnAtLocation(AMItemRegistry.SPIKED_SCUTE.get());
            } else {
                this.spawnAtLocation(TFCBlocks.PLANTS.get(Plant.MOSS).get());
            }
            this.setMoss(0);
        }
    }

    /**
     * @author momo
     * @reason Needed to change the else block to drop TFC moss instead of vanilla Sea grass
     */
    @Nonnull
    @Overwrite
    public java.util.List<ItemStack> onSheared(Player player, ItemStack item, Level world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        this.gameEvent(GameEvent.ENTITY_INTERACT);
        if (!world.isClientSide()) {
            if (random.nextFloat() < this.getMoss() * 0.05F) {
                this.setMoss(0);
                return Collections.singletonList(new ItemStack(AMItemRegistry.SPIKED_SCUTE.get()));
            } else {
                this.setMoss(0);
                return Collections.singletonList(new ItemStack(TFCBlocks.PLANTS.get(Plant.MOSS).get()));
            }
        }
        return java.util.Collections.emptyList();
    }
}
