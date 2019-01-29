import java.util.Calendar;

/* File Name: Patient.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018
 */ 




/*	Represents a Patient to set and get
 *  the patient into the ArrayList
 */ 
public class Patient {
	
	private String firstName, lastName;
	private String healthCardNumber;
	private OurDate birthDate;
	private Calendar now = Calendar.getInstance();
	
	/*
	 * Chain Default Constructor 
	 * no values can be null
	 */
	public Patient() {
		this("unknown", "unknown", "000000000",  new OurDate());	
		
	}
	/*
	 * Overloaded Constructor
	 * to set values since method set is Private
	 */
	public Patient(String firstName, String lastName, String healthCardNumber, OurDate birthDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setHealthCardNumber(healthCardNumber);	
		setBirthDate(birthDate);
	}

	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHealthCardNumber() {
		return healthCardNumber;
	}
	/*
	 * Method setHealthCardNumber throw new Exception if health card number 
	 * dont have 9 digits
	 */
	private void setHealthCardNumber(String healthCardNumber) {
		if (healthCardNumber.length() == 9 && healthCardNumber.matches("[0-9]+") ) {
			this.healthCardNumber = healthCardNumber;
		} else {
			throw new MedicalClinicException("Health card number must be 9 digits in length.");
		}
	}

	public OurDate getBirthDate() {
		return birthDate;
	}
	
	/*
	 * Method setBirthDate throw new Exception if birthDate is  
	 * in the future
	 */
	private void setBirthDate(OurDate birthDate) {
		if (birthDate.getYear() > now.get(Calendar.YEAR)) {
			throw new MedicalClinicException("Birthdate cannot be in the future");
		}
		else if (birthDate.getYear() == now.get(Calendar.YEAR) && birthDate.getMonth()-1 > now.get(Calendar.MONTH)) {
			throw new MedicalClinicException("Birthdate cannot be in the future");
		}
		else if (birthDate.getYear() == now.get(Calendar.YEAR) && birthDate.getMonth()-1 == now.get(Calendar.MONTH) && birthDate.getDay() > now.get(Calendar.DATE)) {
			throw new MedicalClinicException("Birthdate cannot be in the future");
		}
		else if (birthDate.getYear() == now.get(Calendar.YEAR) && birthDate.getMonth()-1 == now.get(Calendar.MONTH) && birthDate.getDay() == now.get(Calendar.DATE)) {
			throw new MedicalClinicException("Birthdate cannot be today");
		} else {
			this.birthDate = birthDate;	
		}
	}

	@Override
	public String toString() {
		return "Patient: "+ lastName + " " + firstName + ", Health Card Number: " + healthCardNumber
				+ ", dob: " + birthDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((healthCardNumber == null) ? 0 : healthCardNumber.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Patient))
			return false;
		Patient other = (Patient) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (healthCardNumber == null) {
			if (other.healthCardNumber != null)
				return false;
		} else if (!healthCardNumber.equals(other.healthCardNumber))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
	
}

