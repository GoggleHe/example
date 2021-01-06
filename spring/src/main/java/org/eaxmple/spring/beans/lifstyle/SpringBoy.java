package org.eaxmple.spring.beans.lifstyle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 *
 **/
public class SpringBoy implements BeanNameAware, BeanClassLoaderAware, ResourceLoaderAware, EmbeddedValueResolverAware, EnvironmentAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String beanName;
    private String name;

    public SpringBoy() {
        System.out.println("constructor");
        System.out.println("name = " + name);
    }

    private void init() {
        System.out.println("init");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory");
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = "name";
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware.setBeanName");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy");
    }

    private void customDestroy() {
        System.out.println("customDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet");
        System.out.println("name = " + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware.setBeanClassLoader");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("EnvironmentAware.setEnvironment");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("ResourceLoaderAware.setResourceLoader");
    }
}
