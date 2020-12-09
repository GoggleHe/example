package org.example.designpattern.abstractfactory;

/**
 *
 **/
public class MaleSuitFactory extends AbstractSuitFactory {

    @Override
    public UpperOuterGarment createUpperOuterGarment() {
        return new MaleJacket();
    }

    @Override
    public LowerGarment createLowerGarment() {
        return new MaleJean();
    }

    @Override
    public Shoes createShoes() {
        return new Caliga();
    }
}
