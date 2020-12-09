package org.example.designpattern.factorymethod;

/**
 *
 **/
public class SwordFactory implements WeaponFactory {
    @Override
    public Weapon create() {
        return new Sword();
    }
}
