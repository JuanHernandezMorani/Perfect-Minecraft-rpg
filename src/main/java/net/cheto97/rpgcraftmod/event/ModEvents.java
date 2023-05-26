package net.cheto97.rpgcraftmod.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.cheto97.rpgcraftmod.RpgcraftMod;
import net.cheto97.rpgcraftmod.block.ModBlocks;
import net.cheto97.rpgcraftmod.customstats.*;
import net.cheto97.rpgcraftmod.item.ModItems;
import net.cheto97.rpgcraftmod.providers.*;
import net.cheto97.rpgcraftmod.villager.ModVillagers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import static net.cheto97.rpgcraftmod.customattributes.RangeDamage.applyCustom;

@Mod.EventBusSubscriber(modid = RpgcraftMod.MOD_ID)
public class ModEvents {
    private static final String MESSAGE_NO_ENOUGH_MANA = "message.rpgcraftmod.not_enough_mana";
    public static int ticks = 0;
    public static int ticksLife = 0;

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
        var entity = event.getObject();
        if( entity instanceof Player | entity instanceof Monster || entity instanceof Animal ){
            if(!entity.getCapability(ManaProvider.ENTITY_MANA).isPresent()){
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"mana"), new ManaProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"manaregeneration"),new ManaRegenerationProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"life"), new LifeProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"liferegeneration"), new LifeRegenerationProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"luck"), new LuckProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"defense"), new DefenseProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"strength"), new StrengthProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"dexterity"), new DexterityProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"command"), new CommandProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"agility"), new AgilityProvider());
                event.addCapability(new ResourceLocation(RpgcraftMod.MOD_ID,"intelligence"), new IntelligenceProvider());
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

            event.getOriginal().getCapability(ManaRegenerationProvider.ENTITY_MANAREGENERATION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(ManaRegenerationProvider.ENTITY_MANAREGENERATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(LifeProvider.ENTITY_LIFE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(LifeProvider.ENTITY_LIFE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(LifeRegenerationProvider.ENTITY_LIFEREGENERATION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(LifeRegenerationProvider.ENTITY_LIFEREGENERATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(LuckProvider.ENTITY_LUCK).ifPresent(oldStore -> {
                event.getOriginal().getCapability(LuckProvider.ENTITY_LUCK).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(DefenseProvider.ENTITY_DEFENSE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(DefenseProvider.ENTITY_DEFENSE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(StrengthProvider.ENTITY_STRENGTH).ifPresent(oldStore -> {
                event.getOriginal().getCapability(StrengthProvider.ENTITY_STRENGTH).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(DexterityProvider.ENTITY_DEXTERITY).ifPresent(oldStore -> {
                event.getOriginal().getCapability(DexterityProvider.ENTITY_DEXTERITY).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(CommandProvider.ENTITY_COMMAND).ifPresent(oldStore -> {
                event.getOriginal().getCapability(CommandProvider.ENTITY_COMMAND).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(AgilityProvider.ENTITY_AGILITY).ifPresent(oldStore -> {
                event.getOriginal().getCapability(AgilityProvider.ENTITY_AGILITY).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(IntelligenceProvider.ENTITY_INTELLIGENCE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(IntelligenceProvider.ENTITY_INTELLIGENCE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onEntityDamage(LivingDamageEvent event){
        var entity = event.getEntity();
        var damage = event.getAmount();
        if(entity != null){
            entity.getCapability(LifeProvider.ENTITY_LIFE).ifPresent(life -> {
                entity.getCapability(DefenseProvider.ENTITY_DEFENSE).ifPresent(defense -> {
                    entity.getCapability(IntelligenceProvider.ENTITY_INTELLIGENCE).ifPresent(intelligence ->{
                        double total_damage;
                        if(event.getSource().isFall() || event.getSource().isExplosion() || event.getSource().isProjectile()){
                            total_damage = damage - (defense.get()*0.40);
                        }else if(event.getSource().isFire() || event.getSource().isMagic()){
                            total_damage = damage - (intelligence.get()*0.5);
                        }else{
                            total_damage = damage - defense.get();
                        }

                        if(total_damage < 0){
                            total_damage = 0;
                        }

                        life.consumeLife((int)total_damage);
                    });
                });
            });
        }
    }

    @SubscribeEvent
    public static void onPotionUsed(LivingEntityUseItemEvent event) {
        var item = event.getItem();
        if(item.getItem() instanceof PotionItem && event.getEntity() != null){
            if(event.getEntity() instanceof Player){
                event.getEntity().getCapability(ManaProvider.ENTITY_MANA).ifPresent(mana -> {
                    if(mana.get() > 9){
                        mana.consumeMana(10);
                    }else{
                        event.setCanceled(true);
                        (event.getEntity()).sendSystemMessage(Component.translatable(MESSAGE_NO_ENOUGH_MANA).withStyle(ChatFormatting.DARK_RED));
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(Mana.class);
        event.register(ManaRegeneration.class);
        event.register(Life.class);
        event.register(LifeRegeneration.class);
        event.register(Agility.class);
        event.register(Defense.class);
        event.register(Luck.class);
        event.register(Strength.class);
        event.register(Command.class);
        event.register(Dexterity.class);
    }

    @SubscribeEvent
    public static void onPlayerCraft(PlayerEvent.ItemCraftedEvent event){
        var entity = event.getEntity();
        var item = event.getCrafting();

        if(entity != null){
            applyCustom(item,entity,1,event.getEntity().getLevel());
        }
    }

    @SubscribeEvent
    public static void onLivingHealEvent(LivingHealEvent event){

        if(event.getEntity() != null){
            event.getEntity().getCapability(LifeRegenerationProvider.ENTITY_LIFEREGENERATION).ifPresent(hpregen ->{
                event.setCanceled(true);
            });
        }
    }

    @SubscribeEvent
    public static void onLivingEntityUpdate(LivingEvent.LivingTickEvent event){
        if (event.getEntity() instanceof Player || event.getEntity() instanceof Monster || event.getEntity() instanceof Animal) {


            event.getEntity().getCapability(LifeProvider.ENTITY_LIFE).ifPresent(life ->{
                event.getEntity().setHealth(life.get());
            });

            event.getEntity().getCapability(AgilityProvider.ENTITY_AGILITY).ifPresent(agility ->{
                event.getEntity().setSpeed(event.getEntity().getSpeed() + (float)(agility.get()*0.0000005));
            });

            event.getEntity().getCapability(ManaRegenerationProvider.ENTITY_MANAREGENERATION).ifPresent(
                    mpRegen -> event.getEntity().getCapability(ManaProvider.ENTITY_MANA).ifPresent(mana -> {
                        if(mana.get() < mana.getMax()){
                            ticks++;
                            if (ticks > 40) {
                                ticks = 0;
                                mana.add(mpRegen.get());
                            }
                        }
                    }));

            event.getEntity().getCapability(LifeRegenerationProvider.ENTITY_LIFEREGENERATION).ifPresent(
                    hpRegen ->  event.getEntity().getCapability(LifeProvider.ENTITY_LIFE).ifPresent(life -> {
                        if(life.get() < life.getMax()){
                            ticksLife++;
                            if(ticksLife > 40){
                                ticksLife = 0;
                                life.add(hpRegen.get());
                            }
                        }}));

        }
    }
}
