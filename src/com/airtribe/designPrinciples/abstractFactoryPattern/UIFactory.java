package com.airtribe.designPrinciples.abstractFactoryPattern;

// Abstract Factory interface
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
