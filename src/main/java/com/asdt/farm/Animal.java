package com.asdt.farm;

public abstract class Animal {

	protected abstract boolean isTired();

	protected abstract boolean isHungry();

	protected abstract void move();

	protected abstract void eat();

    protected abstract void sleep();
    
    public void simulateDay() {
        while (true) {
            while (!isHungry() && !isTired()) {
                move();
            }
            if (isTired()) {
                break;
            } else {
                eat();
                continue;
            }
        }
        sleep();
    }


}
