package Cache.algorithms;

public class DoublyLinkedListNode<E>
{
	DoublyLinkedListNode<E> prev;
	DoublyLinkedListNode<E> next;
	E element;
	
	public DoublyLinkedListNode(E e)
	{
		element = e;
		prev    = null;
		next    = null;
	}
}
