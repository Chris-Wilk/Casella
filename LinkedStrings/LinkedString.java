/**
 * Assignment 07 Linked Strings
 * Creates a class to imitate java's String method by taking chars and putting them into
 * a linked list.
 * @author Chris Wilk
 * @date: 19 October 2023
 * @assignment CIS 203, Assignment 07, Fall 2023
 **/
public class LinkedString {
	private LinkedStringNode head;
	
	/**
	 * Private class to create the list
	 */
	private class LinkedStringNode{	
		private char data;
		private LinkedStringNode next;
		
		/**
		 * the LinkedString constructor initializing data to the input
		 * @param inData the value assigned to data
		 */
	    public LinkedStringNode(char inData) {
	        this.data = inData;
	        this.next = null;
	    }
	    
	    /**
	     * the getCh method will return the data in the node at that spot
	     * @return the data in the node at that spot
	     */
	    char getCh() {
	    	return data;
	    }
	    
	    /**
	     * the getNext method will get return the next node
	     * @return the next node
	     */
	    LinkedStringNode getNext() {
	    	return next;
	    }
	    
	    /**
	     * the setNext method will assign the next node to the parameter passed
	     * @param inNext the next node to be added to the list
	     */
	    void setNext(LinkedStringNode inNext) {
	    	next = inNext;
	    }
	}
	
	/**
	 * The constructor to make the first node in the list null
	 */
    public LinkedString() {
    	head = null;
    }
    
    /**
     * The append method will add the value passed to the end of the list
     * @param ch the value to be added to the end of the list
     */
    public void append(char ch) {
    	LinkedStringNode newNode = new LinkedStringNode(ch);
    	if(head == null) {
    		head = newNode;
    	}else {
    		LinkedStringNode current = head;
    		while (current.getNext() != null) {
    			current = current.getNext();
    		}
    		current.setNext(newNode);;
    	}
    }
    
    /**
     * the length method will return the amount of nodes in the list
     * @return the number of nodes in the list
     */
    public int length() {
    	LinkedStringNode current = head;
    	int count = 0;
    	while(current != null) {
    		count++;
    		current = current.getNext();
    	}
    	return count;
    }
    
    /**
     * the equals method will compare two lists and check to see if have the same values
     * @param that the list to compare 
     * @return true or false if the lists are equal
     */
    public boolean equals(LinkedString that) {
    	boolean end = false;
    	LinkedStringNode thisCurrent = this.head;
    	LinkedStringNode thatCurrent = that.head;
    	while(thisCurrent != null && thatCurrent != null) {
    		if(thisCurrent.getCh() != thatCurrent.getCh()) {
    			return false;
    		}
    		thisCurrent = thisCurrent.getNext();
    		thatCurrent = thatCurrent.getNext();
    	}
    	if(thisCurrent == null && thatCurrent == null) {
    		end = true;
    	}
    	return end;
    }
    
    /**
     * The charAt method will return the character at the passed index
     * @param ndx the index to be returned
     * @return the character at the index
     */
    public char charAt(int ndx) {
    	LinkedStringNode current = head;
    	try {
        	for(int i = 0; i < ndx; i++) {
        		current = current.getNext();
        	}
    	}catch(Exception e) {
    		System.out.println("Error " + e);
    		e.printStackTrace();
    		System.exit(2);
    	}
    	return current.getCh();
    }
    
    /**
     * The toString method will display every character in the list making it look like a string
     */
    public String toString() {
    	LinkedStringNode current = head;
    	String toReturn = "";
    	while(current != null) {
    		toReturn += current.getCh();
    		current = current.getNext();
    	}
    	return toReturn;
    	
    }
}
