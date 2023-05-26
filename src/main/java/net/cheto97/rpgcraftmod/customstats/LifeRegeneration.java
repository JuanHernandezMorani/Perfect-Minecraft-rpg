package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class LifeRegeneration {
    private int liferegeneration = 1;
    private final int MIN_LIFEREGENERATION_VALUE = 0;

    public int get(){
        return liferegeneration;
    }
    public int getMin(){
        return MIN_LIFEREGENERATION_VALUE;
    }
    public void resetStat(){
        liferegeneration = 1;
    }
    public void add(){
            this.liferegeneration++;
    }
    public void add(int value){
            this.liferegeneration = this.liferegeneration + value;
    }
    public void copyFrom(LifeRegeneration source){
        this.liferegeneration = source.liferegeneration;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("liferegeneration",liferegeneration);
    }
    public void loadNBTData(CompoundTag nbt){
        liferegeneration = nbt.getInt("liferegeneration");
    }
}
