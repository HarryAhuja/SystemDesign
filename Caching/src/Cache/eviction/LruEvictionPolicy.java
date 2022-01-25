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

import Cache.algorithms.DoublyLinkedList;
import Cache.algorithms.DoublyLinkedListNode;

public class LruEvictionPolicy<Key> implements evictionPolicy<Key>
{
	private final DoublyLinkedList<Key> dll;
	private final Map<Key,DoublyLinkedListNode<Key>> map;
	
	public LruEvictionPolicy()
	{
		dll 	 = new DoublyLinkedList<>();
		map 	 = new HashMap<>();
	}
	
	public void maintainOrder(Key key)
	{
		// condition should be checked here irrespective of caller checking or not
		// bcs each class should be independently tested
		if(map.containsKey(key))
		{
			dll.detachNode(map.get(key));
			dll.moveNodeAtLast(map.get(key));
		}
		else
		{
			DoublyLinkedListNode<Key> newNode = dll.addNodeAtLast(key);
			map.put(key,newNode);
		} 
	}
	
	public Key evict()
	{
		DoublyLinkedListNode<Key> firstKey = dll.getFirst();
		
		if(firstKey==null)	return null;
		
		dll.detachNode(firstKey);
		map.remove(firstKey.getKey());
		
		return firstKey.getKey();
	}
}
