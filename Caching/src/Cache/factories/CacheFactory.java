package Cache.factories;

import Cache.Cache;
import Cache.eviction.LruEvictionPolicy;
import Cache.storage.HashMapStorage;

public class CacheFactory<Key,Value>
{
	public Cache<Key,Value> defaultCache()
	{
		return new Cache<Key,Value>(new LruEvictionPolicy<Key>(),new HashMapStorage<Key,Value>());
	}
}
