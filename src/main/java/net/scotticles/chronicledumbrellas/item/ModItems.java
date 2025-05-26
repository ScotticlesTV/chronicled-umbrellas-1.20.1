package net.scotticles.chronicledumbrellas.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.scotticles.chronicledumbrellas.ChronicledUmbrellas;
import net.scotticles.chronicledumbrellas.item.custom.UmbrellaItem;

public class ModItems {
    public static final Item RedUmbrella = registerItem("redumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item OrangeUmbrella = registerItem("orangeumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item YellowUmbrella = registerItem("yellowumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item GreenUmbrella = registerItem("greenumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item BlueUmbrella = registerItem("blueumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item PurpleUmbrella = registerItem("purpleumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item BlackUmbrella = registerItem("blackumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item WhiteUmbrella = registerItem("whiteumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));
    public static final Item BrownUmbrella = registerItem("brownumbrella", new UmbrellaItem(new FabricItemSettings().maxCount(1)));

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RedUmbrella);
        entries.add(OrangeUmbrella);
        entries.add(YellowUmbrella);
        entries.add(GreenUmbrella);
        entries.add(BlueUmbrella);
        entries.add(PurpleUmbrella);
        entries.add(BlackUmbrella);
        entries.add(BrownUmbrella);
        entries.add(WhiteUmbrella);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ChronicledUmbrellas.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ChronicledUmbrellas.LOGGER.info("Registering Mod Items for" + ChronicledUmbrellas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}