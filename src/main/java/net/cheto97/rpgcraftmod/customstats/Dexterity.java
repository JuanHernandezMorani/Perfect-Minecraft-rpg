package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Dexterity {
    private final int MIN_DEXTERITY_VALUE = 1;
    private int dexterity = 1;

    public int get(){
        return dexterity;
    }
    public int getMin(){
        return MIN_DEXTERITY_VALUE;
    }
    public void add(){
        dexterity++;
    }
    public void resetStat(){
        dexterity = 1;
    }
    public void add(int value){
        this.dexterity = dexterity + value;
    }
    public void copyFrom(Dexterity source){
        this.dexterity = source.dexterity;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("dexterity",dexterity);
    }
    public void loadNBTData(CompoundTag nbt){
        dexterity = nbt.getInt("dexterity");
    }
}
