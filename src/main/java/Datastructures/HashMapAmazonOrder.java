package Datastructures;

import Datastructures.maps.AmazonOrder;

import java.util.HashMap;

public class HashMapAmazonOrder {

    public static void main(String[] args) {

        HashMap<Integer, AmazonOrder> amazonOrderCache
                = new HashMap();

        AmazonOrder amazonOrder1 = new AmazonOrder(1,"iphone",100);
        AmazonOrder amazonOrder2 = new AmazonOrder(2, "macbook 16", 300);

        amazonOrderCache.put(amazonOrder1.getOrderId(),amazonOrder1);
        System.out.println("Stored Order 1 in amazonOrderCache :" + amazonOrder1);
        amazonOrderCache.put(amazonOrder2.getOrderId(),amazonOrder2);
        System.out.println("Stored Order 2 in amazonOrderCache :" + amazonOrder2);


        ///Fetch / Search/ Read
        AmazonOrder orderSearched1 = amazonOrderCache.get(1);
        System.out.println("AmazonOrder searched with id=1 :" + orderSearched1);


    }
}
