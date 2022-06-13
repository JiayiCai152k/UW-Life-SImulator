package com.example.uw_life_simulator.model;

public class UserAttribute implements Subject {
    private int iq;
    private int luck;
    private int wealth;
    private int health;
    private int availablePoint;
    private int pressure;
    private int totalPoint;

    // Constructor
    public UserAttribute() {
        this.pressure = 0;
        this.iq = 0;
        this.luck = 0;
        this.wealth = 0;
        this.health = 0;
        this.availablePoint = 0;
        this.totalPoint = 0;
    }

    public UserAttribute(int availablePoint) {
        this.availablePoint = availablePoint;
        this.totalPoint = availablePoint;
    }

    // Constructor
    public UserAttribute(int iq, int luck, int wealth, int health, int availablePoint, int pressure, int totalPoint) {
        this.iq = iq;
        this.luck = luck;
        this.wealth = wealth;
        this.health = health;
        this.availablePoint = availablePoint;
        this.totalPoint = totalPoint;
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Talent{" +
                "iq=" + iq +
                ", luck=" + luck +
                ", wealth=" + wealth +
                ", health=" + health +
                ", pressure=" + pressure +
                '}';
    }

    public int getAvailablePoint() {
        return availablePoint;
    }

    public void setAvailablePoint(int availablePoint) {
        this.availablePoint = availablePoint;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getPressure() { return pressure; }

    public void setPressure(int pressure) {this.pressure = pressure; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
