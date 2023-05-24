package net.cheto97.rpgcraftmod.block;

import net.cheto97.rpgcraftmod.RpgcraftMod;
import net.cheto97.rpgcraftmod.custom.ModCreativeModeTab;
import net.cheto97.rpgcraftmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RpgcraftMod.MOD_ID);

    public static final RegistryObject<Block> bloque_mineral_zafiro = registerBlock("bloque_mineral_zafiro.json",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(99.9f)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(5,15)
            ), ModCreativeModeTab.RPGCRAFT_TAB);

    public static final RegistryObject<Block> bloque_profundo_mineral_zafiro = registerBlock("bloque_profundo_mineral_zafiro",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(99.9f)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(5,15)
            ), ModCreativeModeTab.RPGCRAFT_TAB);

    public static final RegistryObject<Block> bloque_zafiro = registerBlock("bloque_zafiro",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(99.9f)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
            ), ModCreativeModeTab.RPGCRAFT_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
