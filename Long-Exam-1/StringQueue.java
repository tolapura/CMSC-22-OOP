import java.util.*;
import java.io.*;

public class StringQueue {

	private String[] elements;
	private int count;
	private int max;
	public static final int DEFAULT_SIZE = 10;

	public StringQueue() {
		elements = new String[DEFAULT_SIZE];
		count = 0;
		max = DEFAULT_SIZE;
	}

	public void enqueue(String str){
		if(count == max){
			expand();
		}
		elements[count++] = str;
	}

	public String dequeue(){
		if(count == 0){
			throw new IllegalArgumentException("Queue is empty.");
		}
		String temp = elements[0];
		for(int i = 0; i < count - 1; i++){
			elements[i] = elements[i+1];
		}
		count--;
		elements[count] = "";
		return temp;
	}

	public String dequeue(int n){
		String ans = "";
		for (int i = 0 ; i < n; i++){
			ans = dequeue();
		}
		return ans;
	}

	public String toString(){
		if(count == 0){
			return "EMPTY";
		}
		String ans = "";
		for (int i = 0; i < count - 1; i++){
			ans += elements[i] + ", ";
		}
		return ans + elements[count - 1];
	}

	public String peek() {
		return elements[0];
	}

	public void singit(int n , String str){
		if(count == max){
			expand();
		}
		if(n >= count){
			enqueue(str);
		} else {
			for(int i = count - 1; i >= n-1 ; i--){
				elements[i+1] = elements[i];
			}
			elements[n-1] =  str;
			count++;
		}
	}

	private void expand() {
		String[] temp = new String[max];
		for (int i = 0; i < count; i++){
			temp[i] = elements[i];
		}
		elements = new String[max + DEFAULT_SIZE];
		for (int i = 0; i < count; i++){
			elements[i] = temp[i];
		}
	}

	public int size(){
		return count;
	}

}