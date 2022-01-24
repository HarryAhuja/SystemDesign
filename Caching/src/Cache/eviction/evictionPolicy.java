package Cache.eviction;

public interface evictionPolicy<Key>
{
	void maintainOrder(Key key);
	
	Key evict();
}
