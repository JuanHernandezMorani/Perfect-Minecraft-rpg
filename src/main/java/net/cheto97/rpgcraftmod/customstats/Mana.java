package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Mana {
    private int mana;
    private final int MIN_MANA_VALUE = 0;
    private final int MAX_MANA_VALUE = 10;

    public int get(){
        return mana;
    }
    public int getMax(){
        return MAX_MANA_VALUE;
    }
    public int getMin(){
        return MIN_MANA_VALUE;
    }
    public void add(int value){
        this.mana = Math.min(mana + value, MAX_MANA_VALUE);
    }
    public void copyFrom(Mana source){
        this.mana = source.mana;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("mana",mana);
    }
    public void loadNBTData(CompoundTag nbt){
        mana = nbt.getInt("mana");
    }
    public void consumeMana(int value){
        this.mana = Math.min(mana - value, MIN_MANA_VALUE);
    }
}
