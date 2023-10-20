package org.example.unittest;

public class Villa {

    private Person owner;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String ownerName() {
        return owner == null ? null : owner.getName();
    }
}
