//package practice.design;
//
//import java.util.Deque;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//
//public class LRUCache {
//    Deque<Integer> node=new LinkedList<>();
//    private Map<Integer, node> cache;
//    private Integer CACHE_SIZE;
//
//    public LRUCache(int capacity) {
//        CACHE_SIZE = capacity;
//        cache = new LinkedHashMap<>();
//    }
//
//    public int get(int key) {
//        return cache.getOrDefault(key, -1);
//    }
//
//    public void set(int key, int val) {
//        if (!this.cache.containsKey(key)
//                && cache.size() == CACHE_SIZE) {
//            Iterator<Integer> it = this.cache.keySet().iterator();
//            it.next();
//            it.remove();
//        }
//        this.cache.put(key, val);
//    }
//
//    public static void main(String[] args) {
//        LRUCache lruCache=new LRUCache(3);
//        lruCache.set(1,100);
//        lruCache.get(2);
//        lruCache.set(2,200);
//        lruCache.set(3,300);
//        lruCache.get(3);
//    }
//}
