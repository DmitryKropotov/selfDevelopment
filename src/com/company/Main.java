package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException{
	// write your code here
        CacheMap cache = new CacheMap(1000);
        cache.put("first", "one");
        Thread.sleep(300);
        cache.put("second", "two");
        Thread.sleep(300);
        System.out.println(cache.contains("first"));//true
        System.out.println(cache.contains("second"));//true
        Thread.sleep(500);
        System.out.println(cache.contains("first"));//false
        System.out.println(cache.contains("second"));//true
        cache.put("second", "three");
        Thread.sleep(250);
        System.out.println(cache.contains("first"));//false
        System.out.println(cache.contains("second"));//true
        Thread.sleep(800);
        System.out.println(cache.contains("second"));//false


    }
}
