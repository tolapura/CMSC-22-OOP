import java.io.*;
import java.util.*;

public class lab2 {

	public static void stringCompare(String name){
	    int count = 0;

		char[] array = name.toCharArray();
        for (int i = 0; i < (array.length)/2; i++){
            for (int j = ((array.length) / 2) + 1; j < array.length; j++){
                if (array[i] == array[j]){
                    array[i] = '0';
                    array[j] = '0';
                    break;
                }
            }
        }
        for (int i = 0; i < array.length; i++){
                if (array[i] != '0')
                count+= 1;
                }

            System.out.println(count / 2);
            }

    public static void main(String args[] ) throws Exception {
    int testcases;
    String name;
    Scanner inputs = new Scanner(System.in);
    	System.out.println("Enter num of testcases: ");
    	testcases = inputs.nextInt();
        do {
    	name = inputs.next();
    	System.out.println(name);
        if (name.length() % 2 == 1){
    		System.out.println(-1);
    	} else {
    		stringCompare(name);
    	} testcases--;
        } while(testcases != 0);
    }
}
