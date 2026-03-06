package com.airtribe.designPrinciples.decoratorPattern;

public class CreamDecorator extends BeverageDecorator{
    CreamDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Cream";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.7;
    }
}
