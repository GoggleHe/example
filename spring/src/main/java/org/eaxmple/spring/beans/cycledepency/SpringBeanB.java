package org.eaxmple.spring.beans.cycledepency;

/**
 *
 **/
public class SpringBeanB {
    private SpringBeanA springBeanA;

    public SpringBeanB() {
    }

    public SpringBeanB(SpringBeanA springBeanA) {
        this.springBeanA = springBeanA;
    }

    public SpringBeanA getSpringBeanA() {
        return springBeanA;
    }

    public void setSpringBeanA(SpringBeanA springBeanA) {
        this.springBeanA = springBeanA;
    }
}
