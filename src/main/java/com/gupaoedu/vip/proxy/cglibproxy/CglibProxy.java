package com.gupaoedu.vip.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 * 对Shooping在内存中动态构建一个子类对象
 */
public class CglibProxy implements MethodInterceptor {
    //维护目标对象
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类（代理对象）
        return en.create();
    }
    //JDK是采用读取接口的信息
    //CGLib覆盖父类方法
    //目的：都是生成一个新的类，去实现增强代码逻辑的功能

    //JDK Proxy 对于用户而言，必须要有一个接口实现，目标类相对来说复杂
    //CGLib 可以代理任意一个普通的类，没有任何要求

    //CGLib 生成代理逻辑更复杂，效率,调用效率更高，生成一个包含了所有的逻辑的FastClass，不再需要反射调用
    //JDK Proxy生成代理的逻辑简单，执行效率相对要低，每次都要反射动态调用

    //CGLib 有个坑，CGLib不能代理final的方法
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("准备买东西了...");
        //执行目标对象方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("买好东西了...");
        return returnValue;
    }
}
