/* File Name: MaternityPatient.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */ 



/*	Represents a MaternityPatient to set and get
 *  the patient subclass into the ArrayList
 */
public class MaternityPatient extends Patient{
	
	private OurDate dueDate;
	private boolean nutritionTesting;
	
	/*
	 * Chain Default Constructor 
	 * no values can be null
	 */
	public MaternityPatient() {
		this("unknown", "unknown", "000000000", new OurDate(), new OurDate(), false);
	}
	/*
	 * Overloaded Constructor
	 * to set values since method set is Private
	 */
	public MaternityPatient(String firstName, String lastName, String healthCardNumber, OurDate birthDate, OurDate dueDate, boolean nutritionTesting) {
		super(firstName, lastName, healthCardNumber, birthDate);
		setDueDate(dueDate);
		setNutritionTesting(nutritionTesting);
	}

	public OurDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(OurDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isNutritionTesting() {
		return nutritionTesting;
	}

	public void setNutritionTesting(boolean nutritionTesting) {
		this.nutritionTesting = nutritionTesting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + (nutritionTesting ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof MaternityPatient))
			return false;
		MaternityPatient other = (MaternityPatient) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (nutritionTesting != other.nutritionTesting)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " dueDate: " + dueDate + ", nutritionTesting: " + nutritionTesting;
	}

}
