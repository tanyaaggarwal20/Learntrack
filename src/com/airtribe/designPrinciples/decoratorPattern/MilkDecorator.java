package com.airtribe.designPrinciples.decoratorPattern;

public class MilkDecorator extends BeverageDecorator {
    MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.5;
    }
}
