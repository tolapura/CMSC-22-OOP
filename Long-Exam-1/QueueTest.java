import java.util.*;
import java.io.*;

public class QueueTest {

	public static void main(String args[]){
		StringQueue test = new StringQueue();
		test.enqueue("First");
		test.enqueue("Second");
		test.enqueue("Third");
		test.enqueue("Fourth");
		test.enqueue("Fifth");
		test.enqueue("Sixth");

		System.out.println(test.size());
		System.out.println(test);

		String temp1 = test.dequeue();
		String temp2 = test.dequeue();

		System.out.println(test);
		System.out.println(test.size());

		System.out.println("LAST ITEM: " + test.peek());

		String temp3 = test.dequeue(2);
		//String temp4 = test.dequeue(10);

		test.singit(1, "Cute");
		test.singit(7, "Cute");

		System.out.println(test.size());
		System.out.println(test);

	}
}
