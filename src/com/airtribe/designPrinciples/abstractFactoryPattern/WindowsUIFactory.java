package com.airtribe.designPrinciples.abstractFactoryPattern;

public class WindowsUIFactory implements  UIFactory{
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowCheckbox();
    }
}
