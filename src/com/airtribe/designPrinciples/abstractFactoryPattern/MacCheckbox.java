package com.airtribe.designPrinciples.abstractFactoryPattern;

// Concrete products for Mac family
public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Mac style checkbox");
    }
}
