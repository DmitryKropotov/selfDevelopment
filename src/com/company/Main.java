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
        System.out.println();

        int a[] = {1, 3, 4, 7};
        int b[] = {2, 4, 6, 8, 10};
        int result[] = mergeSortedArrays(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length+b.length];
        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i<result.length; i++) {
            if (indexA<a.length && a[indexA]<=b[indexB]) {
               result[i] = a[indexA];
               indexA++;
            } else {
                result[i] = b[indexB];
                indexB++;
            }
        }
        return result;
    }
}
