import java.util.*;
import java.io.*;

public class StackTest {

	public static void main(String args[]){
		StringStack test = new StringStack(1);
		StringStack test2 = new StringStack(10);

		test.push("First");
		test.push("Second");
		test.push("Third");
		test.push("Fourth");
		test.push("Fifth");
		test.push("Sixth");

		System.out.println(test.size());
		System.out.println(test);

		String temp1 = test.pop();
		String temp2 = test.pop();
		
		System.out.println(test);
		System.out.println(test.size());

		System.out.println("LAST ITEM: " + test.peek());

		String temp3 = test.pop(2);
		String temp4 = test.pop(10);

	}
}