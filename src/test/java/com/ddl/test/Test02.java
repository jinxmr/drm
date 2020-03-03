package com.ddl.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        // 创建SUV对象
        SUV suv1 = new SUV(5079, 750000);
        SUV suv2 = new SUV(4813, 760000);
        SUV suv3 = new SUV(4270, 127800);
        SUV suv4 = new SUV(4545, 188800);

        //添加到集合中
        ArrayList<SUV> list = new ArrayList<>();
        list.add(suv1);
        list.add(suv2);
        list.add(suv3);
        list.add(suv4);

        // 遍历集合,查询中型SUV
        for (int i = 0; i < list.size(); i++) {
            SUV suv = list.get(i);
            if (suv.midSUV()){
                suv.showMsg();
            }
        }

    }

}
// 定义汽车类
class Auto {
    private String type;
    private double length;
    private double price;

    public Auto() {
    }

    public Auto(String type, double length, double price) {
        this.type = type;
        this.length = length;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showMsg() {
        System.out.println("车型:" + type);
        System.out.println("\t价格:" + price);
        System.out.println("\t车长:" + length);

    }

}

// 定义SUV类
class SUV extends Auto {
    // 车长标准
    private int miniLength = 4295;
    private int midLength = 5070;

    public SUV(double length, double price) {
        super("SUV", length, price);
    }
    // 判断 小型车
    public boolean miniSUV() {
        return getLength() <= miniLength;
    }

    // 判断 大型车
    public boolean largeSUV() {
        return getLength() > midLength;
    }

    // 判断 中型车
    public boolean midSUV() {
        return getLength() > miniLength && getLength() <= midLength;
    }
}