package net.cheto97.rpgcraftmod.networking.packet;

import net.cheto97.rpgcraftmod.providers.ManaProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DrinkManaFluidC2SPacket {
    private static final String MESSAGE_DRINK_MANA_FLUID = "You feel how its restore your mana";

    public DrinkManaFluidC2SPacket(){

    }

    public DrinkManaFluidC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(@NotNull Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if(player != null){

                ServerLevel level = player.getLevel();

                if(hasManaWell(player,level,2)){
                    player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_MANA_FLUID).withStyle(ChatFormatting.BLUE));

                    level.playSound(null, player.getOnPos(), SoundEvents.ALLAY_AMBIENT_WITH_ITEM, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                    player.getCapability(ManaProvider.ENTITY_MANA).ifPresent(mana -> mana.add(mana.getMax()/5));
                }
            }

        });
        return true;
    }

    private boolean hasManaWell(ServerPlayer player, ServerLevel level,int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.LAPIS_BLOCK)).toArray().length > 0;
    }

}
