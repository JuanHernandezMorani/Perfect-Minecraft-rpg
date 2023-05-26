package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Mana {
    private int mana = 10;
    private final int MIN_MANA_VALUE = 0;
    private int MAX_MANA_VALUE = 10;

    public int get(){
        return mana;
    }
    public int getMax(){
        return MAX_MANA_VALUE;
    }
    public int getMin(){
        return MIN_MANA_VALUE;
    }
    public void increaseMax(int value){
        MAX_MANA_VALUE = MAX_MANA_VALUE + value;
    }
    public void increaseMax(){
        MAX_MANA_VALUE++;
    }
    public void resetStat(){
        mana = 10;
        MAX_MANA_VALUE = 10;
    }
    public void add(int value){
        int check = this.mana + value;
        if(this.mana < MAX_MANA_VALUE){
            if(check > MAX_MANA_VALUE){
                check = Math.abs(check - MAX_MANA_VALUE);
            }
           this.mana = check;
        }
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
        int check = mana - value;
        if(check < MIN_MANA_VALUE){
            check = MIN_MANA_VALUE;
        }
        this.mana = check;
    }
}
