/* File Name: Doctor.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */ 



/*	Represents a Doctor to set and get
 *  the Doctor into the ArrayList
 */ 
public class Doctor {
	
	private String firstName, lastName, speciality;
	
	/*
	 * Chain Default Constructor 
	 * no values can be null
	 */
	public Doctor() {
		this("unknown","unknown","unknown");
	}
	/*
	 * Overloaded Constructor
	 * to set values since method set is Private
	 */
	public Doctor(String firstName, String lastName, String speciality) {
		setFirstName(firstName);
		setLastName(lastName);
		setSpeciality(speciality);
		
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

	public String getSpeciality() {
		return speciality;
	}

	private void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Dr. "+ lastName + " " + firstName + ", " + speciality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Doctor))
			return false;
		Doctor other = (Doctor) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		return true;
	}


}
