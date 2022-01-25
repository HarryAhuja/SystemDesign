package Cache.storage;

import Cache.exceptions.*;

public interface Storage<Key,Value>
{
	public void add(Key key,Value value) throws StorageFullException;
	
	public void remove(Key key) throws KeyNotFoundException;
	
	public Value get(Key key) throws KeyNotFoundException;
}
