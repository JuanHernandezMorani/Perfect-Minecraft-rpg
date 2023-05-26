package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Defense {
    private final int MIN_DEFENSE_VALUE = 1;
    private int defense = 1;

    public int get(){
        return defense;
    }
    public int getMin(){
        return MIN_DEFENSE_VALUE;
    }
    public void resetStat(){
        defense = 1;
    }
    public void add(int value){
       this.defense =  this.defense + value;
    }
    public void add(){
        this.defense++;
    }
    public void copyFrom(Defense source){
        this.defense = source.defense;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("defense",defense);
    }
    public void loadNBTData(CompoundTag nbt){
        defense = nbt.getInt("defense");
    }
}
