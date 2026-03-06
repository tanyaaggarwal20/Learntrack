package com.airtribe.designPrinciples.abstractFactoryPattern;

// Concrete products for Windows family
public class WindowCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering Windows style checkbox");
    }
}
