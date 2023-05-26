package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Life {
    private int life = 20;
    private final int MIN_LIFE_VALUE = 0;
    private int MAX_LIFE_VALUE = 20;

    public int get(){
        return life;
    }
    public int getMax(){
        return MAX_LIFE_VALUE;
    }
    public int getMin(){
        return MIN_LIFE_VALUE;
    }
    public void increaseMax(int value){
        MAX_LIFE_VALUE = MAX_LIFE_VALUE + value;
    }
    public void increaseMax(){
        MAX_LIFE_VALUE++;
    }
    public void resetStat(){
        life = 20;
        MAX_LIFE_VALUE = 20;
    }
    public void add(int value){
        int check = this.life + value;
        if(this.life < MAX_LIFE_VALUE){
            if(check > MAX_LIFE_VALUE){
                check = Math.abs(check - MAX_LIFE_VALUE);
            }
            this.life = check;
        }
    }
    public void copyFrom(Life source){
        this.life = source.life;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("life",life);
    }
    public void loadNBTData(CompoundTag nbt){
        life = nbt.getInt("life");
    }
    public void consumeLife(int value){
        int check = life - value;
        if(check < MIN_LIFE_VALUE){
            check = MIN_LIFE_VALUE;
        }
        this.life = check;
    }
}
