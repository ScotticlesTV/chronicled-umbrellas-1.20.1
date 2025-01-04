package net.scotticles.chronicledumbrellas.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.scotticles.chronicledumbrellas.ChronicledUmbrellas;

public class ModItemGroups {
    public static final ItemGroup CHRONICLED_UMBRELLAS_ITEMS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ChronicledUmbrellas.MOD_ID, "chronicledumbrellasitems"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chronicledumbrellasitems"))
                    .icon(() -> new ItemStack(ModItems.PurpleUmbrella)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RedUmbrella);
                        entries.add(ModItems.OrangeUmbrella);
                        entries.add(ModItems.YellowUmbrella);
                        entries.add(ModItems.GreenUmbrella);
                        entries.add(ModItems.BlueUmbrella);
                        entries.add(ModItems.PurpleUmbrella);
                        entries.add(ModItems.BlackUmbrella);
                        entries.add(ModItems.WhiteUmbrella);
                        entries.add(ModItems.BrownUmbrella);
                    }).build());

    public static void registerItemGroups() {
        ChronicledUmbrellas.LOGGER.info("Registering Item Groups for" + ChronicledUmbrellas.MOD_ID);
    }
}