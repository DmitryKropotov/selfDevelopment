package com.company;

import java.util.HashMap;
import java.util.Map;

public class CacheMap<K, V> {

    private int timeToLive;
    private Map<K, V> data = new HashMap<K, V>();
    private Map<K, LocalThread> threads = new HashMap<K, LocalThread>();

    public CacheMap(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void put(K key, V value) {
        if (threads.containsKey(key)) {
            LocalThread oldThread = threads.get(key);
            oldThread.interrupt();
        }
        data.put(key, value);
        LocalThread thread = new LocalThread(key);
        thread.start();
        threads.put(key, thread);
    }

    public boolean contains(K key) {
        return data.containsKey(key);
    }

    private class LocalThread extends Thread {

        private K key;

        public LocalThread(K key) {
            this.key = key;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeToLive);
            } catch (InterruptedException e) {
                return;
            }
            data.remove(key);
        }
    }
}
