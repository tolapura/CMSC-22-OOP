import java.io.*;

public class Date {
	private int year;
	private int month;
	private int day;
	Date() {
		this(1000, 1, 1);
	}
	Date(int year, int month, int day){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public void setYear(int year){
		if (year > 9999 || year < 1000) {
			throw new IllegalArgumentException("INVALID YEAR");
		} else {
			this.year = year;
		}
	}	
	public void setMonth(int month){
		if (month > 12 || month < 0) {
			throw new IllegalArgumentException("INVALID MONTH");
		} else {
			this.month = month;
		}
	}
	public void setDay(int day){
		boolean leap = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ? true : false; 
		if (month == 2 && leap && day > 29) {
			 throw new IllegalArgumentException("INVALID DAY");
		} else if (month == 2 && day > 28) {
			throw new IllegalArgumentException("INVALID DAY");
		} else if (day > 31 && day < 0) {
			throw new IllegalArgumentException("INVALID DAY");
		} else if (day == 31 && (month == 11 || month == 9 || month == 6 || month == 4)) {
			throw new IllegalArgumentException("INVALID DAY");
		} else {
			this.day = day;
		}
	}
	public void setDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	public String toString(){
		return String.format("%02d/%02d/%04d", month, day, year);
	}
}