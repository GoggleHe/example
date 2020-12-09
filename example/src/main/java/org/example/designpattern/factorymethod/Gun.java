package org.example.designpattern.factorymethod;

/**
 *
 **/
public class Gun extends Weapon {
    @Override
    void attack() {
        System.out.println("shoot");
    }
}
