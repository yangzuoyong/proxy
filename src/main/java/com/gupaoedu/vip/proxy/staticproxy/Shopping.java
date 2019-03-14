package com.gupaoedu.vip.proxy.staticproxy;

public class Shopping  implements IShopping{
    @Override
    public void buy() {
        System.out.println("买东西");
    }
}
