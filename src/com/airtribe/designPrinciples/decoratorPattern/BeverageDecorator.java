package com.airtribe.designPrinciples.decoratorPattern;

public abstract class BeverageDecorator implements Beverage {
    Beverage beverage;

    BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
