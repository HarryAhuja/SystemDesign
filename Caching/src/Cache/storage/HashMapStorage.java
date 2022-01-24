package Cache.storage;

import java.util.HashMap;
import java.util.Map;
import Cache.exceptions.*;

public class HashMapStorage<Key,Value> implements Storage<Key,Value> 
{
	Map<Key,Value> map = new HashMap<>();
	
	public void add(Key key,Value value) throws StorageFullException
	{
		if(map.size()==4)
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
