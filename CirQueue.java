/*
 * Susan Hatem
 * hw1011
 * https://github.com/ProgrammerSusan/CirQueue
 */

import java.util.Random;

public class CirQueue {
	
	/*  the data structure   */ 
	public static int  head, tail; // indexes into n[]
	public static int size = 10;
	public static int [] n;

	public static void main(String[] args) {
		initialize();
		
		Random r = new Random(3);
		n = new int[size];
		int x, y, m;
		for(int j = 0; j < 3; j++) {
			x = r.nextInt(5) + 1;
			for(int i = 0; i < x; i++) {
				m = r.nextInt(100);
				insert(m);
			}
			y = r.nextInt(5) + 1;
			for(int i = 0; i < y; i++) {
				delete();
			}
		}
		printQueue();
	}
	
	/* initialize queue pointers */
	public static void initialize() {
		head = tail = 0;
	}

	/* test for full */
	public static boolean isFull() {
		return head == (tail + 1) % size;
	}


	/* test for empty */
	public static boolean isEmpty() {
		return head == (tail + 1) % size;
	}

	/* insert x at tail */
	public static void insert(int x) {
		try { 
			if ( !isFull() ) {
				n[(tail + 1) % size] = x;
				tail = (tail + 1) % size;
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
		
	/* delete from head */
	public static void delete() {
		try {
			if ( !isEmpty() ) {
				n[head] = n[(head + 1) % size];
				head = (head + 1) % size;
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
    }
		
		
	/* print from head to tail */
	/* note, this is not a queue operation, but is handy for debugging */
	public static void printQueue() {
		if ( !isEmpty() ) {
			for (int i = head; i != tail-1 && i < size; i++) {
				System.out.print(n[i] + " ");
			}
		}
		else {
			System.out.print("Empty Queue");
		}
	}
	  
}
