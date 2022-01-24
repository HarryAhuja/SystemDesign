/*
 * Least recently used will be at first of LL
 * Get reference of any node in O(1) with hashmap
 * Delete/Update any node in O(1) with DLL
 * Most recently used at end of the LL
 * 
 *  LRU hashmap and storage hasmap should be different bcs they can be implemented
 *  by different vendors and maybe different storage are used
 *  Coupling should not be there
 */
package Cache.eviction;

import java.util.HashMap;
import java.util.Map;

public class LruEvictionPolicy<Key> implements evictionPolicy<Key>
{
	private final DoublyLinkedList<Key> dll;
	private final Map<Key,DoublyLinkedList<Key>> map;
	
	public LruEvictionPolicy<Key>()
	{
		dll = new DoublyLinkedList<>();
		map = new HashMap<>();
	}
	
	public void maintainOrder(Key key)
	{
		if(map.contains(key))
		{
			dll.detachNode(map.get(key));
			dll.addNodeAtLast(map.get(key));
		}
		else
		{
			DoublyLinkedList<Key> newNode = dll.addElementAtLast(key);
			map.put(key,newNode);
		} 
	}
	
	public Key evict()
	{
		DoublyLinkedList<Key> firstKey = dll.getFirst();
		
		if(firstKey==null)	return null;
		
		dll.detachFirst();
		
		return firstKey.getElement();
	}
}
