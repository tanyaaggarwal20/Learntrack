package com.airtribe.designPrinciples.abstractFactoryPattern;

// Concrete factory for Mac family
public class MacUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
