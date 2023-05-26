package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Strength {
    private int strength = 1;
    private final int MIN_STRENGTH_VALUE = 1;

    public int get(){
        return strength;
    }
    public int getMin(){
        return MIN_STRENGTH_VALUE;
    }
    public void resetStat(){
        strength = 1;
    }

    public void add(){
        this.strength++;
    }

    public void add(int value){
            this.strength = this.strength + value;
    }
    public void copyFrom(Strength source){
        this.strength = source.strength;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("strength",strength);
    }
    public void loadNBTData(CompoundTag nbt){
        strength = nbt.getInt("strength");
    }
}