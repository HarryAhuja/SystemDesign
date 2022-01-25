package Cache.algorithms;

public class DoublyLinkedListNode<Key>
{
	DoublyLinkedListNode<Key> prev;
	DoublyLinkedListNode<Key> next;
	Key key;
	
	public DoublyLinkedListNode()
	{
		key     = null;
		prev    = null;
		next    = null;
	}
	
	public DoublyLinkedListNode(Key k)
	{
		key     = k;
		prev    = null;
		next    = null;
	}
	public Key getKey()
	{
		return this.key;
	}
}
