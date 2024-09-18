import java.util.HashMap;
import java.util.Map;

class Cache {
    private Map<String, String> dataCache = new HashMap<>();

    private Cache() {
        System.out.println("Cache initialized.");
    }

    private static class SingletonHelper {
        private static final Cache INSTANCE = new Cache();
    }

    public static Cache getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void put(String key, String value) {
        dataCache.put(key, value);
    }

    public String get(String key) {
        return dataCache.get(key);
    }
}

public class MainApp {
    public static void main(String[] args) {
        Cache cache1 = Cache.getInstance();
        cache1.put("product-101", "Laptop");

        Cache cache2 = Cache.getInstance();
        System.out.println("Product 101: " + cache2.get("product-101"));

        // Both cache1 and cache2 are the same instance
        System.out.println("cache1 and cache2 are the same instance: " + (cache1 == cache2)); // true
    }
}
