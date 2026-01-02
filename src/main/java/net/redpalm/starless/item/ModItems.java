package net.redpalm.starless.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redpalm.starless.Starless;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Starless.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
