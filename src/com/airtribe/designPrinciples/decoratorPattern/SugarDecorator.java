package com.airtribe.designPrinciples.decoratorPattern;

public class SugarDecorator extends BeverageDecorator{
    SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.3;
    }
}
