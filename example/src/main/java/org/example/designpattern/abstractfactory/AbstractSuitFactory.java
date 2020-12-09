package org.example.designpattern.abstractfactory;

/**
 *
 **/
public abstract class AbstractSuitFactory {

    public abstract UpperOuterGarment createUpperOuterGarment();

    public abstract LowerGarment createLowerGarment();

    public abstract Shoes createShoes();
}
