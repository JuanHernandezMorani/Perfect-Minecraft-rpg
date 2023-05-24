package net.cheto97.rpgcraftmod.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EspadaMuerteItem extends Item {

    public EspadaMuerteItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,15,3));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,15,2));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,15,3));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,50,3));

            player.getCooldowns().addCooldown(this,60);
        }


        return super.use(level, player, hand);
    }
}
