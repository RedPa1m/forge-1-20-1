package net.redpalm.starless.event;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.redpalm.starless.entity.custom.ObserveEntity;

public class EventHandler extends Event {
    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ObserveEntity) {
            event.getEntity().level().playSound(null, event.getEntity().getX(), event.getEntity().getY(),
                    event.getEntity().getZ(), SoundEvents.AMBIENT_CAVE.get(), SoundSource.PLAYERS, 1, 1);
        }
    }
}
