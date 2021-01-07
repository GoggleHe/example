package org.example.spring.beans.cycledepency;

/**
 *
 **/
public class SpringBeanA {

    private SpringBeanB springBeanB;

    public SpringBeanA() {
    }

    public SpringBeanA(SpringBeanB springBeanB) {
        this.springBeanB = springBeanB;
    }

    public SpringBeanB getSpringBeanB() {
        return springBeanB;
    }

    public void setSpringBeanB(SpringBeanB springBeanB) {
        this.springBeanB = springBeanB;
    }
}
