package net.cheto97.rpgcraftmod.networking.packet;

import net.cheto97.rpgcraftmod.client.ClientManaData;
import net.cheto97.rpgcraftmod.providers.ManaProvider;
import net.cheto97.rpgcraftmod.providers.ManaRegenerationProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ManaDataSyncS2CPacket {
    private final double mana;

    public ManaDataSyncS2CPacket(double mana){
        this.mana = mana;
    }

    public ManaDataSyncS2CPacket(FriendlyByteBuf buf){
        this.mana = buf.readDouble();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeDouble(mana);
    }

    public boolean handle(@NotNull Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientManaData.set(mana);
        });
        return true;
    }

}
