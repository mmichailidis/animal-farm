package com.asdt.farm;

public abstract class Animal {
    protected Feeder feeder;
    private AnimalState state;

    protected EatStrategy eatStrategy;

    protected abstract boolean isHungry();

    protected abstract boolean isTired();

    protected abstract void move();

    protected abstract void eat();

    protected abstract void sleep();

    public Animal(Feeder feeder, EatStrategy eatStrategy) {
        this.eatStrategy = eatStrategy;
        state = new AnimalRunningState();
        this.feeder = feeder;
    }

    public EatStrategy getEatStrategy() {
        return eatStrategy;
    }

    public void setEatStrategy(EatStrategy eatStrategy) {
        this.eatStrategy = eatStrategy;
    }

    public void setState(AnimalState newState) {
        state = newState;
    }

    public void simulateStep() {
        state.act(state, this);
    }

    protected void decreaseFood() {
        feeder.decreaseFood();
    }
}
