package org.jpeep.resource;

/**
 * Created by LJT on 17-8-10.
 * email: ljt1343@gmail.com
 */
public class Memory {
    private float maxHeap = 0.0f;

    private float currentHeap = 0.0f;

    private float maxNewGeneration = 0.0f;

    private float currentNewGeneration = 0.0f;

    private float currentSurvivor0 = 0.0f;

    private float currentSurvivor1 = 0.0f;

    private float currentEden = 0.0f;

    private float maxOldSpace = 0.0f;

    private float currentOldSpace = 0.0f;

    private int youngGCEvents = 0;

    private float youngGCTime = 0.0f;

    private int fullGCEvents = 0;

    private float fullGCTime = 0.0f;

    public Memory() {
    }

    public Memory(float maxHeap) {
        this.maxHeap = maxHeap;
    }

    public Memory(float maxHeap, float currentHeap, float maxNewGeneration, float currentNewGeneration,
                  float currentSurvivor0, float currentSurvivor1, float currentEden, float maxOldSpace,
                  float currentOldSpace, int youngGCEvents, float youngGCTime, int fullGCEvents, float fullGCTime) {
        this.maxHeap = maxHeap;
        this.currentHeap = currentHeap;
        this.maxNewGeneration = maxNewGeneration;
        this.currentNewGeneration = currentNewGeneration;
        this.currentSurvivor0 = currentSurvivor0;
        this.currentSurvivor1 = currentSurvivor1;
        this.currentEden = currentEden;
        this.maxOldSpace = maxOldSpace;
        this.currentOldSpace = currentOldSpace;
        this.youngGCEvents = youngGCEvents;
        this.youngGCTime = youngGCTime;
        this.fullGCEvents = fullGCEvents;
        this.fullGCTime = fullGCTime;
    }

    public float getMaxHeap() {
        return maxHeap;
    }

    public void setMaxHeap(float maxHeap) {
        this.maxHeap = maxHeap;
    }

    public float getCurrentHeap() {
        return currentHeap;
    }

    public void setCurrentHeap(float currentHeap) {
        this.currentHeap = currentHeap;
    }

    public float getMaxNewGeneration() {
        return maxNewGeneration;
    }

    public void setMaxNewGeneration(float maxNewGeneration) {
        this.maxNewGeneration = maxNewGeneration;
    }

    public float getCurrentNewGeneration() {
        return currentNewGeneration;
    }

    public void setCurrentNewGeneration(float currentNewGeneration) {
        this.currentNewGeneration = currentNewGeneration;
    }

    public float getCurrentSurvivor0() {
        return currentSurvivor0;
    }

    public void setCurrentSurvivor0(float currentSurvivor0) {
        this.currentSurvivor0 = currentSurvivor0;
    }

    public float getCurrentSurvivor1() {
        return currentSurvivor1;
    }

    public void setCurrentSurvivor1(float currentSurvivor1) {
        this.currentSurvivor1 = currentSurvivor1;
    }

    public float getCurrentEden() {
        return currentEden;
    }

    public void setCurrentEden(float currentEden) {
        this.currentEden = currentEden;
    }

    public float getMaxOldSpace() {
        return maxOldSpace;
    }

    public void setMaxOldSpace(float maxOldSpace) {
        this.maxOldSpace = maxOldSpace;
    }

    public float getCurrentOldSpace() {
        return currentOldSpace;
    }

    public void setCurrentOldSpace(float currentOldSpace) {
        this.currentOldSpace = currentOldSpace;
    }

    public int getYoungGCEvents() {
        return youngGCEvents;
    }

    public void setYoungGCEvents(int youngGCEvents) {
        this.youngGCEvents = youngGCEvents;
    }

    public float getYoungGCTime() {
        return youngGCTime;
    }

    public void setYoungGCTime(float youngGCTime) {
        this.youngGCTime = youngGCTime;
    }

    public int getFullGCEvents() {
        return fullGCEvents;
    }

    public void setFullGCEvents(int fullGCEvents) {
        this.fullGCEvents = fullGCEvents;
    }

    public float getFullGCTime() {
        return fullGCTime;
    }

    public void setFullGCTime(float fullGCTime) {
        this.fullGCTime = fullGCTime;
    }
}
