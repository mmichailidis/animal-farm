package com.asdt.farm;

public abstract class Animal {
    private Feeder feeder;

    private AnimalState state;
	protected abstract boolean isHungry();
    protected abstract boolean isTired();
	protected abstract void move();
	protected abstract void eat();
    protected abstract void sleep();

    public Animal (Feeder feeder) {
        state = new AnimalRunningState();
        this.feeder = feeder;
    }

    public void setState(AnimalState newState) {
        state = newState;
    }

    public void simulateStep() {
        state.act(state, this);
    }

    protected void decreaseFood(){
        feeder.decreaseFood();
    }
}
