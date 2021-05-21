package com.lazyxu.network;

public class Proxy implements Rent{
    private Host host;
    public Proxy(){}
    public Proxy(Host host){
        this.host=host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        heTong();
        fare();
    }
    //看房
    public void seeHouse(){
        System.out.println("中介带看房子");
    }
    //看房
    public void heTong(){
        System.out.println("中介带看房子");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
