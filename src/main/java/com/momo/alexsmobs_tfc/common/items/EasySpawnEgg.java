package com.momo.alexsmobs_tfc.common.items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.common.ForgeSpawnEggItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

// Made this to use Alex's Mobs translations instead of our own
public class EasySpawnEgg extends ForgeSpawnEggItem {

    public EasySpawnEgg(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor, Properties props) {
        super(type, backgroundColor, highlightColor, props);
    }

    @Override
    @NotNull
    // Replace translation key with alex's mobs translation key
    public String getDescriptionId() {
        return super.getDescriptionId().replace("alexsmobs_tfc", "alexsmobs");
    }
}
