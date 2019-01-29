
/* File Name: OurDate.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class OurDate {

	private int day, month, year;
	private static final Calendar CALENDER = Calendar.getInstance();
	private GregorianCalendar cal = new GregorianCalendar();

	/*
	 * Chain Default Constructor no values can be null
	 */
	public OurDate() {
		// this(-1,-1,2000);
		this(CALENDER.get(Calendar.DATE), CALENDER.get(Calendar.MONTH), CALENDER.get(Calendar.YEAR));
	}

	/*
	 * Overloaded Constructor to set values since method set is Private
	 */
	public OurDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	/*
	 * Method setDay throw new Exception if day of the month is not correct
	 */
	private void setDay(int day) {
		if (cal.isLeapYear(year) && month == 2 && (day > 29 || day < 1)) {
			throw new MedicalClinicException("Day should be between 1 and 29 for this month");
		} else if (!cal.isLeapYear(year) && month == 2 && (day > 28 || day < 1)) {
			throw new MedicalClinicException("Day should be between 1 and 28 for this month");
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30 || day < 1)) {
			throw new MedicalClinicException("Day should be between 1 and 30 for this month");
		} else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				&& (day > 31 || day < 1)) {
			throw new MedicalClinicException("Day should be between 1 and 31 for this month");
		} else {
			this.day = day;
		}

	}

	public int getDay() {
		return day;
	}
	
	/*
	 * Method setMonth throw new Exception if month number is not correct
	 */
	private void setMonth(int month) {
		if (month < 1 || month > 12) {
			throw new MedicalClinicException("Month needs to be between 1 and 12");
		} else {
			this.month = month;
		}
	}

	public int getMonth() {
		return month;
	}
	
	/*
	 * Method setYear throw new Exception if year is before 1900
	 */
	private void setYear(int year) {
		if (year < 1900) {
			throw new MedicalClinicException("Year cannot be before 1900");
		} else {
			this.year = year;
		}
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		// return (this == obj);

		if (obj == null)
			return false;

		if (!(obj instanceof OurDate))
			return false;

		OurDate d = (OurDate) obj; // casting

		if (this.getDay() == d.getDay() && this.getMonth() == d.getMonth() && this.getYear() == d.getYear()) {
			return true;
		}

		return false;

	}

}
