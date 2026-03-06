package com.airtribe.designPrinciples.abstractFactoryPattern;

// Concrete products for Windows family
public class WindowButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Windows style button");
    }
}
