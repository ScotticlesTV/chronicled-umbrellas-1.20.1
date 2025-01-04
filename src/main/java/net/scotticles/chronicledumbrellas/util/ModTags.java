package net.scotticles.chronicledumbrellas.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.scotticles.chronicledumbrellas.ChronicledUmbrellas;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> ALL_UMBRELLAS =
                createTag("all_umbrellas");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ChronicledUmbrellas.MOD_ID, name));

        }
    }

}
