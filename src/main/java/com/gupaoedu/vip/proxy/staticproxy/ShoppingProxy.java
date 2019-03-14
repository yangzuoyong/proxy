package com.gupaoedu.vip.proxy.staticproxy;

/**
 * 代理对象，静态代理：静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 * 优点：可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护
 * 解决方法：使用动态代理方式
 */
public class ShoppingProxy implements IShopping {
    private IShopping shopping;

    public ShoppingProxy (IShopping shopping) {
         this.shopping=shopping;
    }

    @Override
    public void buy() {
        System.out.println("准备买东西...");
        shopping.buy();
        System.out.println("买好东西...");
    }
}
