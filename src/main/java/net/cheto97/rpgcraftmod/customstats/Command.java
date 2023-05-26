package net.cheto97.rpgcraftmod.customstats;

import net.minecraft.nbt.CompoundTag;

public class Command {
    private int command = 1;
    private final int MIN_COMMAND_VALUE = 0;

    public int get(){
        return command;
    }
    public int getMin(){
        return MIN_COMMAND_VALUE;
    }
    public void add(){
        command++;
    }
    public void resetStat(){
        command = 1;
    }
    public void add(int value){
            this.command = command + value;
    }
    public void copyFrom(Command source){
        this.command = source.command;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("command",command);
    }
    public void loadNBTData(CompoundTag nbt){
        command = nbt.getInt("command");
    }
}
