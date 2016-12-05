/**
 * Created by mfcobo, tolapura, cftahadlangit on 9/14/16.
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class LargeInteger {
	private int[] array;
	private boolean sign;
	public LargeInteger() {
		array = new int[1];
		sign = true;
	}  //construct a default LargeInteger = 0;
	public LargeInteger(String string) {
		array = new int[string.length()];
		sign = (string.charAt(0) == '-') ? false : true;
		int i = (sign == false) ? 1 : 0;
		for( ; i < string.length(); i++) {
			array[i] = (int)(string.charAt(i) - '0');
		}
	}  // construct a LargeInteger using a String, you may ignore error checking for now
	public LargeInteger(long num) {
		String string = num + "";
		array = new int[string.length()];
		sign = string.charAt(0) == '-' ? false : true;
		int i = sign == false ? 1 : 0;
		for( ; i < string.length(); i++) {
			array[i] = (int)(string.charAt(i) - '0');
		} 
	}  // construct a LargeInteger using a long
	public LargeInteger(LargeInteger var) {
	 	array = var.array;
	 	sign = var.sign;
	}  // construct a LargeInteger using another LargeInteger
	
	public LargeInteger(int[] intArr) {
		array = intArr;
		sign = true;
	}
	public LargeInteger remove(LargeInteger newest){
		if(newest.array.length != 1){
			int scrPos = (newest.array[0] == 0) ? 1 : 0;  
			int len = (scrPos == 0) ? newest.array.length : newest.array.length - 1;
			int[] temp = new int[len];
			System.arraycopy(newest.array, scrPos, temp, 0, len);
			newest.array = temp;
		}
		return newest;
	}
	public boolean greater(LargeInteger a, LargeInteger b){
		if(a.array.length > b.array.length)
			return true;
		else{
			if(a.array.length == b.array.length){
				for(int i = 0; i < a.array.length ; i++){
					if(a.array[i] != b.array[i])
						return (a.array[i] > b.array[i] ? true : false);
				}
				return true;
			}
			return false;
		}
	}
	public String toString(){
		char[] var = new char[array.length];
		int i = 0;
		for(; i < array.length; i++){
			var[i] = (char)('0' + array[i]);
		}
		String string = new String(var);
		return string;
	} //prints out the String value of the LargeInteger
    public LargeInteger add(String string) {
		LargeInteger newLarge = new LargeInteger(string);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.add(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger add(long num) {
		LargeInteger newLarge = new LargeInteger(num);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.add(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger add(LargeInteger newLarge) {
		int[] augend, addend;
		if((sign == newLarge.sign)){
			if(newLarge.array.length > array.length){
				augend = newLarge.array.clone();
				addend = new int[newLarge.array.length];
				System.arraycopy(array,0,addend,newLarge.array.length - array.length, array.length);
			}else{
				augend = array.clone();
				addend = new int[array.length];
				System.arraycopy(newLarge.array,0,addend,array.length - newLarge.array.length, newLarge.array.length);
			}
			int[] sum = new int[augend.length + 1];
			int i = augend.length;
			int j = augend.length - 1;
			int carry = 0;
			for(; j >= 0; j--, i--) {
				sum[i] = ((augend[j] + addend[j]) + carry ) % 10;
				carry = (augend[j] + addend[j] + carry) / 10;
			}
			sum[i] = carry;
			LargeInteger newest = new LargeInteger(sum);
			return newest.remove(newest);	
		}else{
			LargeInteger newest = new LargeInteger(array);
			return newest.subtract(newLarge);
		}
	}
	public LargeInteger subtract(String string){
		LargeInteger newLarge = new LargeInteger(string);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.subtract(newLarge);
		return newest.remove(newest);
	}

	public LargeInteger subtract(long num){
		LargeInteger newLarge = new LargeInteger(num);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.subtract(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger subtract(LargeInteger newLarge){
		int[] menuend, subtrahend;
		if((sign == newLarge.sign)){
			if(newLarge.array.length > array.length){
				menuend = newLarge.array.clone();
				subtrahend =new int[newLarge.array.length];
				System.arraycopy(array,0,subtrahend,newLarge.array.length - array.length, array.length);
				newLarge.sign = !newLarge.sign;
			}else{
				if(array.length == newLarge.array.length){
					LargeInteger newest = new LargeInteger(array);
					newest.sign = sign;
					menuend = (greater(newest, newLarge)) ? array.clone() : newLarge.array.clone();
					subtrahend = (greater(newest, newLarge)) ? newLarge.array.clone() : array.clone();
					newLarge.sign = (greater(newest, newLarge) && sign) ? sign : !sign;
				}else{
					menuend = array.clone();
					subtrahend = new int[array.length];
					System.arraycopy(newLarge.array,0,subtrahend,array.length - newLarge.array.length, newLarge.array.length);
					newLarge.sign = sign;
				}
			}
			int[] diff = new int[menuend.length];
			int i = menuend.length-1;
			for(; i >= 0; i--){
				int num = menuend[i] - subtrahend[i];
				if(i!=0)subtrahend[i-1] = (num < 0) ? subtrahend[i-1] + 1 : subtrahend[i-1];
				diff[i] = (num < 0) ? num + 10 : num;
			}
			LargeInteger newest = new LargeInteger(diff);
			return newest.remove(newest);
		}else{
			newLarge.sign = !newLarge.sign;
			LargeInteger newest = new LargeInteger(array);
			return newest.add(newLarge);
		}
	}
	public LargeInteger multiply(String string){
		LargeInteger newLarge = new LargeInteger(string);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.multiply(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger multiply(long num){
		LargeInteger newLarge = new LargeInteger(num);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.multiply(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger multiply(LargeInteger multiplier){
		LargeInteger multiplicand = new LargeInteger(array);
		LargeInteger product = new LargeInteger();
		product.sign = (sign == multiplier.sign) ? true : false;
		String var = "0";
		if(var.equals(multiplicand.toString()) || var.equals(multiplier.toString())){
			return product;
		}
		int length = multiplier.array.length - 1;
		for(int i = 0; i < multiplier.array.length ; i++, length--){
				LargeInteger temp = new LargeInteger(bits(array,multiplier.array[i],length));
				product = product.add(temp);
			}
		return product;	
	}
	public LargeInteger bits(int[] array, int num, int len){
		int carry = 0;
		int[] temp = new int[array.length + len + 1];
		int i = array.length - 1;
		for(; i>=0; i--){
			temp[i+1] = ((array[i] * num) + carry ) % 10;
			carry = ((array[i] * num) + carry) / 10; 
		}
		temp[i+1] = carry;
		LargeInteger bit = new LargeInteger(temp);
		return bit.remove(bit);
	}
	public LargeInteger divide(String string){
		LargeInteger newLarge = new LargeInteger(string);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.divide(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger divide(long num){
		LargeInteger newLarge = new LargeInteger(num);
		LargeInteger newest = new LargeInteger(array);
		newest.sign = sign;
		newest = newest.divide(newLarge);
		return newest.remove(newest);
	}
	public LargeInteger divide(LargeInteger divisor){
		if(divisor.toString().equals("0")){
			throw new IllegalArgumentException("ERR");
		}
		LargeInteger dividend = new LargeInteger(array);
		LargeInteger quotient = new LargeInteger();
		quotient.sign = (sign == divisor.sign) ? true : false;
		while(greater(dividend,divisor)){
			dividend = dividend.subtract(divisor);
			quotient = quotient.add(1);
		}
		return quotient;
	}
}
