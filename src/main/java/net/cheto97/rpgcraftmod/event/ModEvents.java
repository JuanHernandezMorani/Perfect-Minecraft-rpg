package net.cheto97.rpgcraftmod.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.cheto97.rpgcraftmod.RpgcraftMod;
import net.cheto97.rpgcraftmod.block.ModBlocks;
import net.cheto97.rpgcraftmod.customstats.Mana;
import net.cheto97.rpgcraftmod.item.ModItems;
import net.cheto97.rpgcraftmod.providers.ManaProvider;
import net.cheto97.rpgcraftmod.villager.ModVillagers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RpgcraftMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.espada_muerte.get(),1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
               new ItemStack(ModItems.zafiro.get(),2),
               stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.MAGIC_MASTER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModBlocks.bloque_mana.get(),1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.bloque_profundo_mineral_zafiro.get(),3),
                    stack,10,8,0.02F
            ));
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilityEntity(AttachCapabilitiesEvent<Entity> event){
        var obj = event.getObject();
        if( obj instanceof Player | obj instanceof Monster || obj instanceof Animal ){
            if(!obj.getCapability(ManaProvider.ENTITY_MANA).isPresent()){
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"properties"), new ManaProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        if(event.isWasDeath()){
            event.getOriginal().getCapability(ManaProvider.ENTITY_MANA).ifPresent(oldStore -> {
                event.getOriginal().getCapability(ManaProvider.ENTITY_MANA).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }


    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(Mana.class);
    }

    /*
    Aca vienen las regeneraciones!
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            event.player.getCapability(ManaProvider.ENTITY_MANA).ifPresent(mana -> {
                if (mana.get() > 0 && mana.get() < mana.getMax() {
                    event.player.getCapability(MpRegenProvider.ENTITY_MPREGEN).ifPresent(mp -> {
                    mana.add(mp.get()/20);
                    });
                }
            });
            event.player.getCapability(LifeProvider.ENTITY_LIFE).ifPresent(life -> {
                if (life.get() > 0 && life.get() < life.getMax() {
                    event.player.getCapability(MpRegenProvider.ENTITY_HPREGEN).ifPresent(hp -> {
                    life.add(hp.get()/20);
                    });
                }
            });
        }
    }
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
    var entity = event.getEntity();

        if (entity instanceof Monster || entity instanceof Animal || entity instanceof Player) {
        entity.getCapability(ManaProvider.ENTITY_MANA).ifPresent(mana -> {
                if (mana.get() > 0 && mana.get() < mana.getMax() {
                    entity.getCapability(MpRegenProvider.ENTITY_MPREGEN).ifPresent(mp -> {
                    mana.add(mp.get()/20);
                    });
                }
            });
            entity.getCapability(LifeProvider.ENTITY_LIFE).ifPresent(life -> {
                if (life.get() > 0 && life.get() < life.getMax() {
                    entity.getCapability(MpRegenProvider.ENTITY_HPREGEN).ifPresent(hp -> {
                    life.add(hp.get()/20);
                    });
                }
            });
        }
    }
    }
     */

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            event.player.getCapability(ManaProvider.ENTITY_MANA).ifPresent(mana -> {
                if (mana.get() > 0 && mana.get() < mana.getMax()) {
                    mana.consumeMana(1/20);
                    if( event.player.getRandom().nextFloat() <= 0.05f){
                        event.player.sendSystemMessage(Component.literal("Consumido 1 de mana, resta: "+mana.get()+"/"+mana.getMax()+" Se restara hasta llegar al valor minimo: "+mana.getMin()));
                    }
                }
            });
        }
    }

}
