package com.momo.alexsmobs_tfc.common;

import net.dries007.tfc.util.Helpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AMTFCTags {

    public static class Items {
        // public static final TagKey<Item> MOOSE_FOOD = create("moose_foods");

        private static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, Helpers.identifier(id));
        }
    }
}
