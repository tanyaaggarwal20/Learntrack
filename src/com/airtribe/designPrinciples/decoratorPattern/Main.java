package com.airtribe.designPrinciples.decoratorPattern;

public class Main {
    public static void main(String[] args) {
        //simple coffee
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription() +  " = $" + coffee.getCost());

        //add milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        //add sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        //add cream
        coffee = new CreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        //deluxe coffee with everything already present
        Beverage deluxeCoffee = new CreamDecorator(
                                    new MilkDecorator(
                                            new SugarDecorator(
                                                    new Coffee()
                                            )
                                    )
                                );

        System.out.println(deluxeCoffee.getDescription() + " = $" + deluxeCoffee.getCost());

    }
}
