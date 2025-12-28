package net.redpalm.starless.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.redpalm.starless.Starless;

@Mod.EventBusSubscriber(modid = Starless.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
}
