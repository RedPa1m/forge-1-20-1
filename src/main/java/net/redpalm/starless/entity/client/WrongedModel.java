package net.redpalm.starless.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.redpalm.starless.Starless;
import net.redpalm.starless.entity.custom.WrongedEntity;
import software.bernie.geckolib.model.GeoModel;

public class WrongedModel extends GeoModel<WrongedEntity> {
    @Override
    public ResourceLocation getModelResource(WrongedEntity wrongedEntity) {
        return new ResourceLocation(Starless.MODID, "geo/wronged.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WrongedEntity wrongedEntity) {
        return new ResourceLocation(Starless.MODID, "textures/entity/wronged.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WrongedEntity wrongedEntity) {
        return new ResourceLocation(Starless.MODID, "animations/wronged.animation.json");
    }
}
