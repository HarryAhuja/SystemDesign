import Cache.factories.CacheFactory;
import Cache.Cache;

public class MainDriver {

	public static void main(String[] args) {
		
		CacheFactory<String,Integer> cacheFactory = new CacheFactory<>();
		Cache<String, Integer> cache			  = cacheFactory.defaultCache();
		
		cache.put("Harry", 25);
		cache.put("Sherry", 25);
		cache.put("Ajay", 24);
		cache.put("Abhay", 26);
		
		System.out.println(cache.get("Harry"));
		System.out.println(cache.get("Sherry"));
		cache.put("Mudit", 24);
		System.out.println(cache.get("Mudit"));

	}

}
