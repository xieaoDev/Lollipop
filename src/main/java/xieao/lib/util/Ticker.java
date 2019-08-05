package xieao.lib.util;

import net.minecraft.nbt.CompoundNBT;

public class Ticker {

    private int max;
    private int ticks;

    public Ticker(int max) {
        this.max = max;
    }

    public boolean done() {
        if (this.ticks < this.max) {
            this.ticks++;
            return false;
        }
        return true;
    }

    public void back() {
        if (this.ticks > 0) {
            this.ticks--;
        }
    }

    public void back(int value) {
        if (this.ticks > 0) {
            this.ticks -= Math.min(this.ticks, value);
        }
    }

    public void reset() {
        this.ticks = 0;
    }

    public static boolean delayed(int delay) {
        return System.currentTimeMillis() % (delay * 5) == 0;
    }

    public void read(CompoundNBT compound, String key) {
        this.ticks = compound.getInt(key);
    }

    public void write(CompoundNBT compound, String key) {
        compound.putInt(key, this.ticks);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }
}