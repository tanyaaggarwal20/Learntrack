package com.airtribe.designPrinciples.abstractFactoryPattern;

// Concrete products for Mac family
public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac style button");
    }
}
