package Cache.algorithms;

public class DoublyLinkedList<Key>
{
     DoublyLinkedListNode<Key> head;
     DoublyLinkedListNode<Key> tail;

     public DoublyLinkedList()
     {
    	 head		  = new DoublyLinkedListNode<Key>();
    	 tail		  = new DoublyLinkedListNode<Key>();
    	 head.next	  = tail;
    	 tail.prev	  = head;
     }
     
     public boolean isEmpty()
     {
    	 return (head.next==tail);
     }
     
	 public  void detachNode(DoublyLinkedListNode<Key> node)
     { 
		node.prev.next = node.next;
		node.next.prev = node.prev;
     }
	
	 public void moveNodeAtLast(DoublyLinkedListNode<Key> node)
	 {
		tail.prev.next = node;
		node.next	   = tail;
		node.prev	   = tail.prev;
		tail.prev	   = node;
	 }
	 
	 public DoublyLinkedListNode<Key> addNodeAtLast(Key key)
	 {
		 DoublyLinkedListNode<Key> new_node = new DoublyLinkedListNode<Key>(key);
		 moveNodeAtLast(new_node);
		 
		 return new_node;
	 }
	
	
	 public DoublyLinkedListNode<Key> getFirst()
	 {
		if(isEmpty())	return null;
		else			return head.next;
	 }
	 
	 public DoublyLinkedListNode<Key> getLast()
	 {
		 if(isEmpty())	return null;
		 else			return tail.prev;
	 }
	
	
}
