package net.cheto97.rpgcraftmod.customattributes;

import net.cheto97.rpgcraftmod.providers.DexterityProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RangeDamage {
    private final double damage;
    private final double projectileSpeed;
    private final double damageMultiplier;

    RangeDamage(double damage, double projectileSpeed, double damageMultiplier) {
        this.damage = damage*damageMultiplier*(projectileSpeed*0.25);
        this.projectileSpeed = projectileSpeed;
        this.damageMultiplier = damageMultiplier;
    }

    public double getDamage() {
        return damage;
    }

    public double getProjectileSpeed() {
        return projectileSpeed;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public static void custom(double damage, double projectileSpeed, double adjustingMultiplier) {
        new RangeDamage(damage, projectileSpeed, adjustingMultiplier);
    }

    private static void setName(ItemStack stack,String itemName,Integer tier,int crafted){



    }

    private static int selectTier() {
        double[] tierPercentages = {0.4, 0.25, 0.15, 0.09, 0.05, 0.03, 0.02, 0.01, 0.005, 0.0005, 0.00005};

        double totalPercentage = 0.0;
        for (double percentage : tierPercentages) {
            totalPercentage += percentage;
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalPercentage;

        double cumulativePercentage = 0.0;
        int selectedTier = 1;
        for (int i = 0; i < tierPercentages.length; i++) {
            cumulativePercentage += tierPercentages[i];
            if (randomNumber < cumulativePercentage) {
                selectedTier = i + 1;
                break;
            }
        }

        return selectedTier;
    }


    private static void addTier(ItemStack stack,int crafted){
        String name = stack.getItem().getName(stack).getString();

        CompoundTag displayTag = stack.getOrCreateTagElement("display");

        int opt = selectTier();

        switch (crafted){
            case 1 -> {
                switch (opt) {
                    case 1 -> {
                        Component iQualityComponent = Component.literal("[Crafted - Common]").withStyle(ChatFormatting.GRAY);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent));
                    }
                    case 2 -> {
                        Component iQualityComponent2 = Component.literal("[Crafted - Uncommon]").withStyle(ChatFormatting.DARK_GRAY);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent2));
                    }
                    case 3 -> {
                        Component iQualityComponent3 = Component.literal("[Crafted - Very Uncommon]").withStyle(ChatFormatting.WHITE);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent3));
                    }
                    case 4 -> {
                        Component iQualityComponent4 = Component.literal("[Crafted - Rare]").withStyle(ChatFormatting.AQUA);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent4));
                    }
                    case 5 -> {
                        Component iQualityComponent5 = Component.literal("[Crafted - Very Rare]").withStyle(ChatFormatting.GREEN);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent5));
                    }
                    case 6 -> {
                        Component iQualityComponent6 = Component.literal("[Crafted - Ultra Rare]").withStyle(ChatFormatting.DARK_AQUA);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent6));
                    }
                    case 7 -> {
                        Component iQualityComponent7 = Component.literal("[Crafted - Ultra Really Rare]").withStyle(ChatFormatting.DARK_GREEN);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent7));
                    }
                    case 8 -> {
                        Component iQualityComponent8 = Component.literal("[Crafted - Epic]").withStyle(ChatFormatting.DARK_PURPLE);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent8));
                    }
                    case 9 -> {
                        Component iQualityComponent9 = Component.literal("[Crafted - Legendary]").withStyle(ChatFormatting.GOLD);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent9));
                    }
                    case 10 -> {
                        Component iQualityComponent10 = Component.literal("[Crafted - Mythic]").withStyle(ChatFormatting.LIGHT_PURPLE);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent10));
                    }
                    case 11 -> {
                        Component iQualityComponent11 = Component.literal("[Crafted - GodLike]").withStyle(ChatFormatting.RED);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent11));
                    }
                }
            }
            case 2 -> {
                switch (opt) {
                    case 1 -> {
                        Component iQualityComponent = Component.literal("[Common]").withStyle(ChatFormatting.GRAY);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent));
                    }
                    case 2 -> {
                        Component iQualityComponent2 = Component.literal("[Uncommon]").withStyle(ChatFormatting.DARK_GRAY);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent2));
                    }
                    case 3 -> {
                        Component iQualityComponent3 = Component.literal("[Very Uncommon]").withStyle(ChatFormatting.WHITE);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent3));
                    }
                    case 4 -> {
                        Component iQualityComponent4 = Component.literal("[Rare]").withStyle(ChatFormatting.AQUA);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent4));
                    }
                    case 5 -> {
                        Component iQualityComponent5 = Component.literal("[Very Rare]").withStyle(ChatFormatting.GREEN);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent5));
                    }
                    case 6 -> {
                        Component iQualityComponent6 = Component.literal("[Ultra Rare]").withStyle(ChatFormatting.DARK_AQUA);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent6));
                    }
                    case 7 -> {
                        Component iQualityComponent7 = Component.literal("[Ultra Really Rare]").withStyle(ChatFormatting.DARK_GREEN);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent7));
                    }
                    case 8 -> {
                        Component iQualityComponent8 = Component.literal("[Epic]").withStyle(ChatFormatting.DARK_PURPLE);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent8));
                    }
                    case 9 -> {
                        Component iQualityComponent9 = Component.literal("[Legendary]").withStyle(ChatFormatting.GOLD);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent9));
                    }
                    case 10 -> {
                        Component iQualityComponent10 = Component.literal("[Mythic]").withStyle(ChatFormatting.LIGHT_PURPLE);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent10));
                    }
                    case 11 -> {
                        Component iQualityComponent11 = Component.literal("[GodLike]").withStyle(ChatFormatting.RED);
                        displayTag.putString("Name", Component.Serializer.toJson(iQualityComponent11));
                    }
                }
            }
        }

        Component iNameComponent = Component.literal(name).withStyle(ChatFormatting.YELLOW);
        displayTag.putString("Name", Component.Serializer.toJson(iNameComponent));
        stack.setTag(displayTag);
    }

    public static void applyCustom(ItemStack item, @Nullable Player player, int crafted, Level level) {
        if (player == null) return;
        Item customItem = item.getItem();

        if(level.isClientSide){
            if(customItem instanceof ArmorItem || customItem instanceof BowItem || customItem instanceof SwordItem || customItem instanceof AxeItem || customItem instanceof PickaxeItem || customItem instanceof HoeItem
                    || customItem instanceof CrossbowItem || customItem instanceof TridentItem){
                addTier(item,crafted);
                if (customItem instanceof BowItem) {
                    player.getCapability(DexterityProvider.ENTITY_DEXTERITY).ifPresent(extraDamage ->{
                        setLore(item, ((1+(extraDamage.get()*0.001))*(3.0*0.25)*1.6));
                        custom((1+(extraDamage.get()*0.001)), 2.40, 1.6);
                        item.setDamageValue((int)Math.round(((1+(extraDamage.get()*0.001))*(3.0*0.25)*1.6)));
                    });
                } else if (customItem instanceof CrossbowItem) {
                    player.getCapability(DexterityProvider.ENTITY_DEXTERITY).ifPresent(extraDamage ->{
                        setLore(item, ((2+(extraDamage.get()*0.0015))*(4.15*0.35)*1.1));
                        custom((2 + extraDamage.get()*0.0015), 4.15, 1.1);
                        item.setDamageValue((int) Math.round((2+(extraDamage.get()*0.001))*(4.15*0.35)*1.1));
                    });
                } else if (customItem instanceof TridentItem){
                    player.getCapability(DexterityProvider.ENTITY_DEXTERITY).ifPresent(extraDamage ->{
                        setLore(item, ((1+(extraDamage.get()*0.0025))*(2.15*0.25)*1.9));
                        custom((1 + extraDamage.get()*0.0025)*1.12, 1.15, 1.9);
                        item.setDamageValue((int)Math.round((1+(extraDamage.get()*0.0025))*(2.15*0.25)*1.9));
                    });
                }
            }
        }


    }

    private static void setLore(@NotNull ItemStack itemStack, Double damage) {
        CompoundTag displayTag = itemStack.getOrCreateTagElement("display");

        ListTag loreTag = new ListTag();

            Component loreComponent = Component.literal("Attack damage: "+ damage).withStyle(ChatFormatting.GREEN);
            StringTag loreStringTag = StringTag.valueOf(Component.Serializer.toJson(loreComponent));
            loreTag.add(loreStringTag);

        displayTag.put("Lore", loreTag);

        itemStack.setTag(displayTag);
    }
}
