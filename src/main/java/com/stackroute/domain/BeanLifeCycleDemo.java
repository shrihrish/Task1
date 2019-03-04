package com.stackroute.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public abstract class BeanLifeCycleDemo implements InitializingBean, DisposableBean {

    public static void main(String[] args) {

        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");

        ((ClassPathXmlApplicationContext) applicationContext). registerShutdownHook();

        BeanLifeCycleDemo beanLifeCycleDemo = (BeanLifeCycleDemo) applicationContext.getBean("lifecycle");
    }

    public void  customInit() {
        System.out.println("Initialization");

    }

    public void clean()
    {
        System.out.println("custom destroy");
    }

    public void customDestroy() {
        System.out.println("Destroyed");
    }

    public void afterPropertiesSet () throws Exception {
        System.out.println("After properties");

    }
}
