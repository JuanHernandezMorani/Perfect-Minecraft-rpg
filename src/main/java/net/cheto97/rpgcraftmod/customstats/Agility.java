package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Agility {
    private int agility = 1;
    private final int MIN_AGILITY_VALUE = 0;

    public int get(){
        return agility;
    }
    public int getMin(){
        return MIN_AGILITY_VALUE;
    }
    public void add(){
        agility++;
    }
    public void resetStat(){
        agility = 1;
    }
    public void add(int value){
            this.agility = this.agility + value;
    }
    public void copyFrom(Agility source){
        this.agility = source.agility;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("agility",agility);
    }
    public void loadNBTData(CompoundTag nbt){
        agility = nbt.getInt("agility");
    }
}
