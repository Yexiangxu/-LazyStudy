package com.lazyxu.network;

import org.junit.Test;

public class Client {
    @Test
    public void main() {
        //房东要出租房子
        Host host=new Host();
        //代理给中介
        Proxy proxy=new Proxy(host);
        proxy.rent();
    }
}
