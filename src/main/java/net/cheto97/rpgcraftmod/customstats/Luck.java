package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Luck {
    private int luck = 1;
    private final int MIN_LUCK_VALUE = 0;

    public int get(){
        return luck;
    }
    public int getMin(){
        return MIN_LUCK_VALUE;
    }
    public void add(){
        this.luck++;
    }
    public void resetStat(){
        luck = 1;
    }
    public void add(int value){
            this.luck = this.luck + value;
    }
    public void copyFrom(Luck source){
        this.luck = source.luck;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("luck",luck);
    }
    public void loadNBTData(CompoundTag nbt){
        luck = nbt.getInt("luck");
    }
}
