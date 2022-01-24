/*
 * SR: Single responsibility
 * IS: Interface segregation
 * OE: open for extension and closed for modification
 * 
 * Get/put and eviction are in different class for SR
 * 
 * Storage interface is different bcs of SR+OE. It can be hashmap or reddis or any
 * Storage is an interface that specifies requirement specification and it can
 * be implemented by any vendor(exntesibilty). We are just injecting any type of storage
 * in cache
 * 
 * evictionPolicy is also interface bcs of extensibility
 * 
 * storage and evictionPolicy are kept different for IS. If kept same, then there must be 
 * a class like HashMapLRU(two functionalities)
 * 
 * DoublyLinkedList is made separate bcs of SR+ anyone can use it independently. If
 * made within LRU then two functionalities to be used together(not reusable easily)
 * tightly coupled
 * 
 * Bcs of this modular and SR design, we can test each class independentl
 * 
 */

package Cache;

import Cache.exceptions.*;

public class Cache<Key,Value>
{
	private final EvictionPolicy<Key> evictionPolicy;
	private final Storage<Key,Value>  storage;
	
	public Cache()
	{
		evictionPolicy = null;
		storage		   = null;
	}
	
	// Cache is extensibile and re-usable for any type of storage
	// dependency inversion principle followed here
	// final variables once initiliased inside constructor are immutable after that
	public Cache(EvictionPolicy<Key> evictionPolicy,Storage<Key,Value> storage)
	{
		this.evictionPolicy = evictionPolicy;
		this.storage		= storage;
	}
	
	public void put(Key key,Value value)
	{
		try
		{
			storage.add(key,value);
			evictionPolicy.maintainOrder(key);
		}
		catch(StorageFullException e)
		{
			System.out.println(e.getMessage());
			Key evictedKey = evictionPolicy.evict();
			
			if(evictedKey == null)
			{
				throw new RuntimeException("Storage is full and no key to evict");
			}
			
			storage.remove(evictedKey);
			put(key,value);
		}
	}
	
	public Value get(Key key)
	{
		try
		{
			Value value = storage.get(key);
			evictionPolicy.maintainOrder(key);
			return value;
		}
		catch(KeyNotFoundException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
		
		
	}
}
