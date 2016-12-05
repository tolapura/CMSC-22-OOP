import java.util.*;
import java.io.*;

public class StringStack {

	private String[] elements;
	private int count;
	private int max;
	public static final int DEFAULT_SIZE = 10;

	public StringStack() {
		this(DEFAULT_SIZE);
	}

	public StringStack(int size){
		if (size < 0) {
			throw new IllegalArgumentException("Bawal negative!");
		} else {
			elements = new String[size];
			count = 0;
			max = DEFAULT_SIZE;
		}
	}

	public int size() {
		return count;
	}

	public void push(String item){
		if (count == max){
			expand();
		}
			element[count] = item;
			count++;
		}
	}

	public String pop() {
		if (count == 0){
			throw new IllegalArgumentException("Stack is empty!");
		}
		count--;
		String temp = elements[count];
		elements[count] = "";
		return temp;
	}

	public String pop(int n) {
		String ans = "";
		for (int i = count - 1; i > n; i--){
			ans = pop();
		}
		return ans;
	}


	public String peek() {
		return elements[count - 1];
	}


	private void expand() {
		String[] temp = new temp[max];
		for (int i = 0; i < count; i++){
			temp[i] = elements[i];
		}
		elements = new String[max + DEFAULT_SIZE];
		for (int i = 0; i < count; i++){
			elements[i] = temp[i];
		}
	}

	public String toString(){
		if (count == 0){
			return "EMPTY";
		}
		String ans = "";
		for (int i = 0; i < count - 1; i++){
			ans += elements[i] + ", ";
		}
		return ans + elements[count - 1];
	}

}