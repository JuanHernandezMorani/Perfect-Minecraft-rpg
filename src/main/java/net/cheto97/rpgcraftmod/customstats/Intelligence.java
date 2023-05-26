package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Intelligence {
    private final int MIN_INTELLIGENCE_VALUE = 1;
    private int intelligence = 1;

    public int get(){
        return intelligence;
    }
    public int getMin(){
        return MIN_INTELLIGENCE_VALUE;
    }
    public void resetStat(){
        intelligence = 1;
    }
    public void add(int value){
        this.intelligence =  this.intelligence + value;
    }
    public void add(){
        this.intelligence++;
    }
    public void copyFrom(Intelligence source){
        this.intelligence = source.intelligence;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("intelligence",intelligence);
    }
    public void loadNBTData(CompoundTag nbt){
        intelligence = nbt.getInt("intelligence");
    }
}
