package org.example.designpattern.abstractfactory;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        MaleSuitFactory maleSuitFactory = new MaleSuitFactory();
        UpperOuterGarment maleJacket = maleSuitFactory.createUpperOuterGarment();
        System.out.println(maleJacket.name());
        LowerGarment maleJean =  maleSuitFactory.createLowerGarment();
        System.out.println(maleJean.name());
        Shoes caliga = maleSuitFactory.createShoes();
        System.out.println(caliga.name());

        FemaleSuitFactory femaleSuitFactory = new FemaleSuitFactory();
        FemaleJacket femaleJacket = (FemaleJacket) femaleSuitFactory.createUpperOuterGarment();
        System.out.println(femaleJacket.name());
        Skirt skirt = (Skirt) femaleSuitFactory.createLowerGarment();
        System.out.println(skirt.name());
        HighHeeledShoes highHeeledShoes = (HighHeeledShoes) femaleSuitFactory.createShoes();
        System.out.println(highHeeledShoes.name());
    }
}
