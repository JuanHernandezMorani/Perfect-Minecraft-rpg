package net.cheto97.rpgcraftmod.painting;

import net.cheto97.rpgcraftmod.RpgcraftMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, RpgcraftMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> PLANTS = PAINTING_VARIANTS.register("plants",
            () -> new PaintingVariant(16,16));

    public static final RegistryObject<PaintingVariant> WASTELANDS = PAINTING_VARIANTS.register("wastelands",
            () -> new PaintingVariant(16,16));

    public static final RegistryObject<PaintingVariant> AZTEC = PAINTING_VARIANTS.register("aztec",
            () -> new PaintingVariant(16,16));

    public static final RegistryObject<PaintingVariant> WANDERER = PAINTING_VARIANTS.register("wanderer",
            () -> new PaintingVariant(16,32));

    public static final RegistryObject<PaintingVariant> SUNSET = PAINTING_VARIANTS.register("sunset",
            () -> new PaintingVariant(32,16));

    public static final RegistryObject<PaintingVariant> FIGHTERS = PAINTING_VARIANTS.register("fighters",
            () -> new PaintingVariant(64,32));

    public static final RegistryObject<PaintingVariant> BUST = PAINTING_VARIANTS.register("bust",
            () -> new PaintingVariant(32,32));

    public static final RegistryObject<PaintingVariant> POINTER = PAINTING_VARIANTS.register("pointer",
            () -> new PaintingVariant(64,64));

    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}
