package org.example.designpattern.factorymethod;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        Weapon sword = new SwordFactory().create();
        sword.attack();

        Weapon gun = new GunFactory().create();
        gun.attack();
    }
}
