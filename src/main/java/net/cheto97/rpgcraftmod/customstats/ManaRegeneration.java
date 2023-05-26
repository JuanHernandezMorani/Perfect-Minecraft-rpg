package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class ManaRegeneration {
    private int manaregeneration = 1;
    private final int MIN_VALUE = 0;

    public int get(){
        return manaregeneration;
    }

    public int getMin(){
        return MIN_VALUE;
    }

    public void increaseMax(){
        manaregeneration++;
    }

    public void resetStat(){
        manaregeneration = 1;
    }

    public void add(int value){
            this.manaregeneration =  this.manaregeneration + value;
    }

    public void copyFrom(ManaRegeneration source){
        this.manaregeneration = source.manaregeneration;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("manaregeneration",manaregeneration);
    }
    public void loadNBTData(CompoundTag nbt){
        manaregeneration = nbt.getInt("manaregeneration");
    }

}
