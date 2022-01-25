package Cache.storage;

import java.util.HashMap;
import java.util.Map;
import Cache.exceptions.*;

public class HashMapStorage<Key,Value> implements Storage<Key,Value> 
{
	final Map<Key,Value> map;
	final int 	  capacity;
	
	public HashMapStorage()
	{
		this.capacity = 0;
		this.map	  = new HashMap<>();
	}
	public HashMapStorage(int c)
	{
		this.capacity = c;
		this.map	  = new HashMap<>();
	}
	
	public boolean isStorageFull()
	{
		return (map.size()==capacity);
	}
	
	public void add(Key key,Value value) throws StorageFullException
	{
		if(isStorageFull())
		{
			throw new StorageFullException("Storage is full. Evicting key");
		}
		map.put(key, value);
	}
	
	public void remove(Key key) throws KeyNotFoundException
	{
		if(map.containsKey(key))	map.remove(key);
		else						throw new KeyNotFoundException("Key Not found");
	}
	
	public Value get(Key key) throws KeyNotFoundException
	{
		if(map.containsKey(key))	return map.get(key);
		else						throw new KeyNotFoundException("Key Not found");
	}
}
