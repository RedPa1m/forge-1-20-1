package net.redpalm.starless.event;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.redpalm.starless.Starless;
import net.redpalm.starless.entity.ModEntities;
import net.redpalm.starless.entity.custom.ObserveEntity;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Starless.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler extends Event {
    static Random random = new Random();
    static ServerLevel serverlevel;
    static int observeX;
    static int observeZ;
    // Playing cave noise for Observe upon him spawning
    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ObserveEntity && !event.getLevel().isClientSide) {
            event.getLevel().playSound(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(),
                    SoundEvents.AMBIENT_CAVE.get(), SoundSource.HOSTILE, 1.5f, 0.85f);
        }
    }
    // Attempt to spawn Observe after some amount of ticks with 10% chance
    @SubscribeEvent
    public static void levelTickEvent (TickEvent.LevelTickEvent tick) {
        if (tick.phase == TickEvent.Phase.END) {
        if (!tick.level.isClientSide && tick.level.getDayTime() % 8000 == 0 && random.nextInt(10) == 0) {
            ObserveEntity entity = ModEntities.OBSERVE.get().create(tick.level);
            if (entity != null) {
                if (serverlevel != null) {
                    Player player = serverlevel.getRandomPlayer();
                    if (player != null) {
                    observeX = (int)player.getX() + random.nextInt(15) + 5;
                    observeZ = (int)player.getZ() + random.nextInt(15) + 5;
                    entity.setPos(observeX, tick.level.getHeight(Heightmap.Types.WORLD_SURFACE,
                        observeX, observeZ), observeZ);
                    tick.level.addFreshEntity(entity); }
                    }
                else {
                    Player player_sp = Minecraft.getInstance().player;
                    if (player_sp != null) {
                        observeX = (int)player_sp.getX() + random.nextInt(15) + 5;
                        observeZ = (int)player_sp.getZ() + random.nextInt(15) + 5;
                        entity.setPos(observeX, tick.level.getHeight(Heightmap.Types.WORLD_SURFACE,
                                observeX, observeZ), observeZ);
                        tick.level.addFreshEntity(entity);
                        }
                    }
                }
            }
        }
    }
}
