package org.jpeep.processor;

/**
 * Created by LJT on 17-8-9.
 * email: ljt1343@gmail.com
 */
public abstract class Worker implements Runnable {
    private boolean alive = true;

    public boolean isAlive() {
        return alive;
    }

    public void killWorker() {
        alive = false;
    }

    public abstract void handler();
}
