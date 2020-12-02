package org.example.designpattern.factorymethod;

/**
 *
 **/
public class GunFactory implements WeaponFactory {

    @Override
    public Weapon create() {
        return new Gun();
    }

}
