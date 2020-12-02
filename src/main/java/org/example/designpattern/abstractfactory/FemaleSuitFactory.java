package org.example.designpattern.abstractfactory;

/**
 *
 **/
public class FemaleSuitFactory extends AbstractSuitFactory {

    @Override
    public UpperOuterGarment createUpperOuterGarment() {
        return new FemaleJacket();
    }

    @Override
    public LowerGarment createLowerGarment() {
        return new Skirt();
    }

    @Override
    public Shoes createShoes() {
        return new HighHeeledShoes();
    }
}
