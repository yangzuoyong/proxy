package com.gupaoedu.vip.proxy;

import com.gupaoedu.vip.proxy.cglibproxy.CglibProxy;
import com.gupaoedu.vip.proxy.cglibproxy.CglibShopping;
import com.gupaoedu.vip.proxy.jdkproxy.JdkProxy;
import com.gupaoedu.vip.proxy.staticproxy.IShopping;
import com.gupaoedu.vip.proxy.staticproxy.Shopping;
import com.gupaoedu.vip.proxy.staticproxy.ShoppingProxy;

public class ProxyTest {
    public static void main(String[] args) {
        //CglibShopping:目标对象；ShoppingProxy：代理对象,把目标对象传给代理对象,建立代理关系
        ShoppingProxy proxy = new ShoppingProxy(new Shopping());
        //执行的是代理的方法
        proxy.buy();
        System.out.println("静态代理end");
        System.out.println("jdk代理begin...");

        // 给目标对象，创建代理对象
        IShopping jdkProxy = (IShopping) new JdkProxy(new Shopping()).getProxyInstance();
        System.out.println(jdkProxy.getClass());
        //执行代理对象的方法
        jdkProxy.buy();
        System.out.println("jdk代理end");
        System.out.println("cglib代理begin...");
        //代理对象
        CglibShopping cglibShopping = (CglibShopping) new CglibProxy(new CglibShopping()).getProxyInstance();
        //执行代理对象的方法
        cglibShopping.buy();
        System.out.println("cglib代理end");
    }
}
